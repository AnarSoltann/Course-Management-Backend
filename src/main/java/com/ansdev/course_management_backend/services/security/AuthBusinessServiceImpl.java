package com.ansdev.course_management_backend.services.security;

import com.ansdev.course_management_backend.constants.OTPConstants;
import com.ansdev.course_management_backend.exception.BaseException;
import com.ansdev.course_management_backend.models.common.proceedkey.ProceedKey;
import com.ansdev.course_management_backend.models.dto.RefreshTokenDto;
import com.ansdev.course_management_backend.models.dto.SendOTPDto;
import com.ansdev.course_management_backend.models.enums.branch.BranchStatus;
import com.ansdev.course_management_backend.models.enums.user.UserStatus;
import com.ansdev.course_management_backend.models.mappers.CourseEntityMapper;
import com.ansdev.course_management_backend.models.mappers.UserEntityMapper;
import com.ansdev.course_management_backend.models.mybatis.branch.Branch;
import com.ansdev.course_management_backend.models.mybatis.course.Course;
import com.ansdev.course_management_backend.models.mybatis.employee.Employee;
import com.ansdev.course_management_backend.models.mybatis.role.Role;
import com.ansdev.course_management_backend.models.mybatis.user.User;
import com.ansdev.course_management_backend.models.payload.auth.LoginPayload;
import com.ansdev.course_management_backend.models.payload.auth.RefreshTokenPayload;
import com.ansdev.course_management_backend.models.payload.auth.signup.SignUpOTPChannelRequest;
import com.ansdev.course_management_backend.models.payload.auth.signup.SignUpOTPRequest;
import com.ansdev.course_management_backend.models.payload.auth.signup.SignUpPayload;
import com.ansdev.course_management_backend.models.response.auth.LoginResponse;
import com.ansdev.course_management_backend.services.branch.BranchService;
import com.ansdev.course_management_backend.services.course.CourseService;
import com.ansdev.course_management_backend.services.employee.EmployeeService;
import com.ansdev.course_management_backend.services.otp.OTPFactory;
import com.ansdev.course_management_backend.services.otp.OTPProceedTokenManager;
import com.ansdev.course_management_backend.services.redis.RedisService;
import com.ansdev.course_management_backend.services.role.RoleService;
import com.ansdev.course_management_backend.services.user.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static com.ansdev.course_management_backend.models.enums.response.ErrorResponseMessages.EMAIL_ALREADY_REGISTERED;
import static com.ansdev.course_management_backend.utils.CommonUtils.throwIf;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthBusinessServiceImpl implements AuthBusinessService {

    final static String BRANCH_NAME_DEFAULT_PATTERN = "%s Default Branch";

    final AuthenticationManager authenticationManager;
    final AccessTokenManager accessTokenManager;
    final RefreshTokenManager refreshTokenManager;
    final UserService userService;
    final UserDetailsService userDetailsService;
    final BCryptPasswordEncoder passwordEncoder;
    final RoleService roleService;
    final CourseService courseService;
    final BranchService branchService;
    final EmployeeService employeeService;
    final OTPProceedTokenManager otpProceedTokenManager;
    final RedisService redisService;

    @Override
    public LoginResponse login(LoginPayload payload) {

        authenticate(payload);
        return prepareLoginResponse(payload.getEmail(), payload.isRememberMe());
    }

    @Override
    public LoginResponse refresh(RefreshTokenPayload payload) {
        return prepareLoginResponse(
                refreshTokenManager.getEmail(payload.getRefreshToken()),
                payload.isRememberMe()
        );
    }

    @Override
    public void logout() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.info("{} user logout succeed", userDetails.getUsername());
    }

    @Override
    public ProceedKey signUp(SignUpPayload payload) {

        throwIf(()-> userService.checkByEmail(payload.getEmail()), BaseException.of(EMAIL_ALREADY_REGISTERED));

        Role defaultRole = roleService.getDefaultRole();
        User user = UserEntityMapper.INSTANCE.fromSignUpPayloadToUser(
                payload,
                passwordEncoder.encode(payload.getPassword()),
                defaultRole.getId()
        );
        userService.insert(user);
        Course course = CourseEntityMapper.INSTANCE.fromSignUpPayload(payload);
        courseService.insert(course);
        branchService.insert(populateDefaultBranchData(payload, course));
        employeeService.insert(Employee.builder().userId(user.getId()).build());
        return ProceedKey.builder().proceedKey(otpProceedTokenManager.generate(user)).build();
    }

    @Override
    public void signUpOTP(SignUpOTPChannelRequest payload) {
        User user = userService.getById(otpProceedTokenManager.getId(payload.getProceedKey()));
        OTPFactory.handle(payload.getChannel()).send(SendOTPDto.of(payload.getChannel().getTarget(user), String.format(OTPConstants.SIGN_UP, user.getId()))
        );
    }

    @Override
    public void signUpOTPConfirmation(SignUpOTPRequest payload) {
        User user = userService.getById(otpProceedTokenManager.getId(payload.getProceedKey()));
        final String otp = redisService.get(String.format(OTPConstants.SIGN_UP, user.getId()));
        if (payload.getOtp().equals(otp)) {
            user.setStatus(UserStatus.ACTIVE);
            userService.update(user);
            log.info("User confirmed!");
        }
        // OTP NOT FOUND
    }

    @Override
    public void setAuthentication(String email) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);

        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities())
        );
    }

    // private util methods

    private void authenticate(LoginPayload request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );
        } catch (AuthenticationException e) {
            throw e.getCause() instanceof BaseException ?
                    (BaseException) e.getCause() :
                    BaseException.unexpected();
        }
    }

    private LoginResponse prepareLoginResponse(String email, boolean rememberMe) {
        User user = userService.getByEmail(email);

        return LoginResponse.builder()
                .accessToken(accessTokenManager.generate(user))
                .refreshToken(refreshTokenManager.generate(
                        RefreshTokenDto.builder()
                                .user(user)
                                .rememberMe(rememberMe)
                                .build()
                ))
                .build();
    }

    private Branch populateDefaultBranchData(SignUpPayload payload, Course course) {
        // TODO: customize field setters
        return Branch.builder()
                .name(BRANCH_NAME_DEFAULT_PATTERN.formatted(payload.getCourseName()))
                .status(BranchStatus.ACTIVE)
                .address(payload.getAddress())
                .courseId(course.getId())
                .build();
    }
}