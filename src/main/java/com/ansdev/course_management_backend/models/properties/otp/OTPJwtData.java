package com.ansdev.course_management_backend.models.properties.otp;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OTPJwtData {

    String secretKey;

}