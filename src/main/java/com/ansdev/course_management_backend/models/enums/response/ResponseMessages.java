package com.ansdev.course_management_backend.models.enums.response;

import org.springframework.http.HttpStatus;

public interface ResponseMessages {

    String key();
    String message();
    HttpStatus status();

}
