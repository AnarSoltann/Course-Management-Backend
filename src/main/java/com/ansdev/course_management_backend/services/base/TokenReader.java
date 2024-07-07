package com.ansdev.course_management_backend.services.base;

public interface TokenReader <T> {

    T read(String token);
}
