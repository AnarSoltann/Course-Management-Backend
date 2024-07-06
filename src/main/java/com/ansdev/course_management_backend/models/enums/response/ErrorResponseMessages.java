package com.ansdev.course_management_backend.models.enums.response;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public enum ErrorResponseMessages implements ResponseMessages {
    UNEXPECTED("unexpected", "An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR),
    NOT_FOUND("not_found_%s", "%s not found by %s", HttpStatus.NOT_FOUND),
    EMAIL_ALREADY_REGISTERED("email_already_registered", "Email already registered", HttpStatus.CONFLICT),
    USER_NOT_ACTIVE("user_not_active", "User is not active", HttpStatus.FORBIDDEN),
    FORBIDDEN("forbidden", "Forbidden", HttpStatus.FORBIDDEN),
    OTP_IS_NOT_VALID("otp_is_not_valid", "OTP is not valid", HttpStatus.CONFLICT),
    PHONE_NUMBER_ALREADY_EXIST("phone_number_already_exist", "Phone number already exist", HttpStatus.CONFLICT),
    STUDENT_ALREADY_ADDED_TO_GROUP("student_already_added_to_group", "Student already added to group", HttpStatus.CONFLICT),

    ;

    String key;
    String message;
    HttpStatus status;


    @Override
    public String key() {
        return key;
    }

    @Override
    public String message() {
        return message;
    }

    @Override
    public HttpStatus status() {
        return status;
    }
}