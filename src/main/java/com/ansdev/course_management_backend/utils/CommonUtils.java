package com.ansdev.course_management_backend.utils;

import com.ansdev.course_management_backend.exception.BaseException;

public class CommonUtils {

    @FunctionalInterface
    public interface Checker {
        boolean check();
    }

    public static void throwIf(Checker checker, BaseException ex) {
        if (checker.check()) {
            throw ex;
        }
    }

}