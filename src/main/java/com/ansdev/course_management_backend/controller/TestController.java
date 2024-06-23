package com.ansdev.course_management_backend.controller;

import com.ansdev.course_management_backend.models.base.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @GetMapping("/test")
    public BaseResponse<String> test() {
        return BaseResponse.success("Hello World");


    }

}