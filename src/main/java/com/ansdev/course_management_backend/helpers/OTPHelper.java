package com.ansdev.course_management_backend.helpers;

import com.ansdev.course_management_backend.exception.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;
import static com.ansdev.course_management_backend.models.enums.response.ErrorResponseMessages.OTP_IS_NOT_VALID;


@Component
@RequiredArgsConstructor
public class OTPHelper {

    private final RedisService redisService;

    public String generate() {
        Random random = new Random();
        return String.format("%04d", random.nextInt(10000));
    }

    public void isValid(String key, String otp) {

        String storedOtp = redisService.get(key);

        if (storedOtp == null || !storedOtp.equals(otp)) {
            throw BaseException.of(OTP_IS_NOT_VALID);
        }

    }

}