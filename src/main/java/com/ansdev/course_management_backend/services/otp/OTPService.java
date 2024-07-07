package com.ansdev.course_management_backend.services.otp;

import com.ansdev.course_management_backend.models.dto.SendOTPDto;

public interface OTPService {

    void send(SendOTPDto sendOTPDto);


}
