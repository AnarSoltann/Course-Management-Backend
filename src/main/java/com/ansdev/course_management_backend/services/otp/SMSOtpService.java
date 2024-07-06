package com.ansdev.course_management_backend.services.otp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SMSOTPServiceImpl implements OTPService{

    private final RedisService redisService;
    private final OTPHelper otpHelper;

    @Override
    public void send(SendOTPDto dto) {
        final String otp = otpHelper.generate();

        redisService.set(dto.getKey(), otp, 5);

        log.info("OTP sent via SMS to: {}, OTP: {}", dto.getTarget(), otp);
    }


}