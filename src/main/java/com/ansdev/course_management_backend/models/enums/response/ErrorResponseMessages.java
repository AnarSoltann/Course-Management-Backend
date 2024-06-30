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