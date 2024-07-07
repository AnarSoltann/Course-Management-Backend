package com.ansdev.course_management_backend.services.otp;

import com.ansdev.course_management_backend.helpers.OTPHelper;
import com.ansdev.course_management_backend.models.dto.SendOTPDto;
import com.ansdev.course_management_backend.services.redis.RedisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailOTPServiceImpl implements OTPService{

    private final RedisService redisService;
    private final OTPHelper otpHelper;

    @Override
    public void send(SendOTPDto dto) {
        final String otp = otpHelper.generate();
        redisService.set(dto.getKey(), otp, 5);
        log.info("OTP sent via Email to: {}, OTP: {}", dto.getTarget(), otp);
    }
}