package com.ansdev.course_management_backend.services.security;

import com.ansdev.course_management_backend.exception.BaseException;
import com.ansdev.course_management_backend.models.dto.RefreshTokenDto;
import com.ansdev.course_management_backend.models.enums.branch.BranchStatus;
import com.ansdev.course_management_backend.models.mappers.CourseEntityMapper;
import com.ansdev.course_management_backend.models.mappers.UserEntityMapper;
import com.ansdev.course_management_backend.models.mybatis.branch.Branch;
import com.ansdev.course_management_backend.models.mybatis.course.Course;
import com.ansdev.course_management_backend.models.mybatis.role.Role;
import com.ansdev.course_management_backend.models.mybatis.user.User;
import com.ansdev.course_management_backend.models.payload.auth.LoginPayload;
import com.ansdev.course_management_backend.models.payload.auth.RefreshTokenPayload;
import com.ansdev.course_management_backend.models.payload.auth.SignUpPayLoad;
import com.ansdev.course_management_backend.models.response.auth.LoginResponse;
import com.ansdev.course_management_backend.services.branch.BranchService;
import com.ansdev.course_management_backend.services.course.CourseService;
import com.ansdev.course_management_backend.services.role.RoleService;
import com.ansdev.course_management_backend.services.user.UserService;
import lombok.RequiredArgsConstructor;
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

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthBusinessServiceImpl implements AuthBusinessService{
    private final static String BRANCH_NAME_DEFAULT_PATTERN = "%s Default Branch";

    private final AuthenticationManager authenticationManager;
    private final AccessTokenManager accessTokenManager;
    private final RefreshTokenManager refreshTokenManager;
    private final UserService userService;
    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleService roleService;
    private final CourseService courseService;
    private final BranchService branchService;




    @Override
    public LoginResponse login(LoginPayload payload) {
        authenticate(payload);
        return generateLoginResponse(payload.getEmail(), payload.isRememberMe());
    }

    @Override
    public LoginResponse refreshToken(RefreshTokenPayload payload) {
         return generateLoginResponse(refreshTokenManager.getEmail(payload.getRefreshToken()),
                 payload.isRememberMe());
    }

    @Override
    public void signUp(SignUpPayLoad payload) {
        if (userService.checkByEmail(payload.getEmail())){
            throw BaseException.of(EMAIL_ALREADY_REGISTERED);
        }

        Role defaultRole = roleService.getDefaultRole();
    // Stage 1: Insert user
        User user = UserEntityMapper.INSTANCE.fromSignUpPayLoadToUser(
                payload,
                bCryptPasswordEncoder.encode(payload.getPassword()),
                defaultRole.getId());
        userService.insert(user);

    // Stage 2: Insert course
        Course course = CourseEntityMapper.INSTANCE.fromSignUpPayLoad(payload);
        courseService.insert(course);

    // Stage 3: Insert default branch

        Branch branch = populateDefaultBranch(payload,course);
        branchService.insert(branch);



    }

    @Override
    public void logout() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.info(" {} User logged out", userDetails.getUsername());
    }

    @Override
    public void setAuthentication(String email) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities())
        );

    }


    //private  util methods

    private void authenticate(LoginPayload request) {
            try{
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),
                request.getPassword()));
            }catch (AuthenticationException e){
                //todo: Implement custom exception
                throw new RuntimeException("Invalid email/password supplied");
            }
    }

    private LoginResponse generateLoginResponse(String email, Boolean rememberMe){
        User user = userService.getByEmail(email);
        return LoginResponse.builder()
                .accessToken(accessTokenManager.generate(user))
                .refreshToken(refreshTokenManager.generate(RefreshTokenDto.builder()
                        .user(user)
                        .rememberMe(rememberMe)
                        .build()))
                .build();
    }

    private Branch populateDefaultBranch(SignUpPayLoad payload,Course course){
        //todo: customize field setters
        return Branch.builder()
                .name(BRANCH_NAME_DEFAULT_PATTERN.formatted(payload.getCourseName()))
                .status(BranchStatus.ACTIVE)
                .address(payload.getAddress())
                .courseId(course.getId())
                .build();
    }
}