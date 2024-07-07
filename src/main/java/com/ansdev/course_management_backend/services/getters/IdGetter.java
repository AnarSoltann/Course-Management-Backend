package com.ansdev.course_management_backend.services.getters;

public interface IdGetter<ID> {

    ID getId(String token);

}