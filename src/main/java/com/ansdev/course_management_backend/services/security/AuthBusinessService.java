package com.ansdev.course_management_backend.services.security;

import com.ansdev.course_management_backend.models.common.proceedkey.ProceedKey;
import com.ansdev.course_management_backend.models.payload.auth.LoginPayload;
import com.ansdev.course_management_backend.models.payload.auth.RefreshTokenPayload;
import com.ansdev.course_management_backend.models.payload.auth.signup.SignUpOTPChannelRequest;
import com.ansdev.course_management_backend.models.payload.auth.signup.SignUpOTPRequest;
import com.ansdev.course_management_backend.models.payload.auth.signup.SignUpPayload;
import com.ansdev.course_management_backend.models.response.auth.LoginResponse;

public interface AuthBusinessService {

    LoginResponse login(LoginPayload payload);

    LoginResponse refresh(RefreshTokenPayload payload);

    void logout();

    ProceedKey signUp(SignUpPayload payload);

    void signUpOTP(SignUpOTPChannelRequest payload);

    void signUpOTPConfirmation(SignUpOTPRequest payload);

    void setAuthentication(String email);


}
