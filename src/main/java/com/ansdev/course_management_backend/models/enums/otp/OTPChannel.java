package com.ansdev.course_management_backend.models.enums.otp;

import com.ansdev.course_management_backend.exception.BaseException;
import com.ansdev.course_management_backend.models.mybatis.user.User;

public enum OTPChannel {
    SMS, EMAIL;

    public String getTarget(User user) {
        if (this.equals(SMS)) {
            return user.getPhoneNumber();
        } else if (this.equals(EMAIL)) {
            return user.getEmail();
        } else {
            throw BaseException.unexpected();
        }
    }
}