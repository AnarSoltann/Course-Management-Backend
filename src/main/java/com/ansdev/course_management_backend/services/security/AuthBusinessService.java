package com.ansdev.course_management_backend.services.security;

import com.ansdev.course_management_backend.models.payload.auth.*;
import com.ansdev.course_management_backend.models.response.auth.LoginResponse;

public interface AuthBusinessService {

    LoginResponse login(LoginPayload payload);

    LoginResponse refreshToken(RefreshTokenPayload payload);

    void signUp(SignUpPayload payload);

    void logout();

    void signUpOTP(SignUpOTPChannelRequest payload);

    void signUpOTPConfirmation(SignUpOTPRequest payload);

    void setAuthentication(String email);


}
