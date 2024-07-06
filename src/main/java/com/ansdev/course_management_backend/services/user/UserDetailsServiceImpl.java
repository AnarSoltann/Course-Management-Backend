package com.ansdev.course_management_backend.services.user;

import com.ansdev.course_management_backend.exception.BaseException;
import com.ansdev.course_management_backend.models.enums.response.ErrorResponseMessages;
import com.ansdev.course_management_backend.models.mybatis.user.User;
import com.ansdev.course_management_backend.models.security.LoggedInUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User  user = userService.getByEmail(username);

        if(!user.IsActive()){
            throw new UsernameNotFoundException(ErrorResponseMessages.USER_NOT_ACTIVE.message(),
                    BaseException.of(ErrorResponseMessages.USER_NOT_ACTIVE));
        }

        return new LoggedInUserDetails(
                user.getEmail(), user.getPassword(), new ArrayList<>());
    }
}
