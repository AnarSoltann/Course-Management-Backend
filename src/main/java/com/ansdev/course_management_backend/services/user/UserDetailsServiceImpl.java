package com.ansdev.course_management_backend.services.user;

import com.ansdev.course_management_backend.exception.BaseException;
import com.ansdev.course_management_backend.models.enums.response.ErrorResponseMessages;
import com.ansdev.course_management_backend.models.mybatis.user.User;
import com.ansdev.course_management_backend.models.security.LoggedInUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.ansdev.course_management_backend.models.enums.response.ErrorResponseMessages.USER_NOT_ACTIVE;
import static com.ansdev.course_management_backend.utils.CommonUtils.throwIf;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    // todo: currently our system supports only email login, but in the future
    //  we have to implement phone number version
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.getByEmail(username);

        throwIf(()-> !user.isActive(),BaseException.of(USER_NOT_ACTIVE));

        return new LoggedInUserDetails(
                user.getEmail(), user.getPassword(), new ArrayList<>()
        );
    }
}