package com.ansdev.course_management_backend.controller;


import com.ansdev.course_management_backend.models.base.BaseResponse;
import com.ansdev.course_management_backend.models.dto.RefreshTokenDto;
import com.ansdev.course_management_backend.models.mybatis.user.User;
import com.ansdev.course_management_backend.models.payload.auth.LoginPayload;
import com.ansdev.course_management_backend.models.response.auth.LoginResponse;
import com.ansdev.course_management_backend.services.security.AccessTokenManager;
import com.ansdev.course_management_backend.services.security.RefreshTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {


    private final AccessTokenManager accessTokenManager;
    private final RefreshTokenManager refreshTokenManager;



    @PostMapping("/login")
    public BaseResponse<LoginResponse>login(@RequestBody LoginPayload payload){

        User user = User.builder().email("anar@gmail.com").build();
        user.setId(1L);



        return BaseResponse.success(LoginResponse.builder()
                .accessToken(accessTokenManager.generate(user))
                .refreshToken(refreshTokenManager.generate(RefreshTokenDto.builder()
                        .user(user).rememberMe(payload.isRememberMe()).build()))
                .build());



    }








}
