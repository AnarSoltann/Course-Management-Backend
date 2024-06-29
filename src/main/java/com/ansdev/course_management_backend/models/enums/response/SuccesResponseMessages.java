package com.ansdev.course_management_backend.models.enums.response;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public enum SuccesResponseMessages implements ResponseMessages{

    SUCCESS("success", "SUCCESS", HttpStatus.OK);

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
