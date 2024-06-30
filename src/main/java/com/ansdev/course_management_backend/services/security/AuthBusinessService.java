package com.ansdev.course_management_backend.services.security;

import com.ansdev.course_management_backend.models.payload.auth.LoginPayload;
import com.ansdev.course_management_backend.models.payload.auth.RefreshTokenPayload;
import com.ansdev.course_management_backend.models.payload.auth.SignUpPayLoad;
import com.ansdev.course_management_backend.models.response.auth.LoginResponse;

public interface AuthBusinessService {

    LoginResponse login(LoginPayload payload);

    LoginResponse refreshToken(RefreshTokenPayload payload);

    void signUp(SignUpPayLoad payload);

    void logout();

    void setAuthentication(String email);


}
