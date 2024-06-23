package com.ansdev.course_management_backend.services.base;

public interface TokenGenerator <T> {

    String generate(T obj);

}
