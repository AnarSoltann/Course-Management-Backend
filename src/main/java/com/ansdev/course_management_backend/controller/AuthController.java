package com.ansdev.course_management_backend.controller;

import com.ansdev.course_management_backend.models.base.BaseResponse;
import com.ansdev.course_management_backend.models.payload.auth.LoginPayload;
import com.ansdev.course_management_backend.models.payload.auth.RefreshTokenPayload;
import com.ansdev.course_management_backend.models.payload.auth.SignUpPayLoad;
import com.ansdev.course_management_backend.models.response.auth.LoginResponse;
import com.ansdev.course_management_backend.services.security.AuthBusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {


    private final AuthBusinessService authBusinessService;

    @PostMapping("/login")
    public BaseResponse<LoginResponse>login(@RequestBody LoginPayload payload){
        return BaseResponse.success(authBusinessService.login(payload));
    }

    @PostMapping("/token/refresh")
    public BaseResponse<LoginResponse> refreshToken(@RequestBody RefreshTokenPayload payload) {
        return BaseResponse.success(authBusinessService.refreshToken(payload));
    }

    @PostMapping("/logout")
    public BaseResponse<Void> logout() {
        authBusinessService.logout();
        return BaseResponse.success();
    }


    @PostMapping("/sign-up")
    public BaseResponse<Void> signUp(@RequestBody SignUpPayLoad payload){
      //  System.out.println(UserEntityMapper.INSTANCE.fromSignUpPayLoadToUser(payload,"123123",1L));
        authBusinessService.signUp(payload);
        return BaseResponse.success();
    }








}
