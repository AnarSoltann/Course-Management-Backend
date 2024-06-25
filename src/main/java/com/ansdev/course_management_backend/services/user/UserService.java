package com.ansdev.course_management_backend.services.user;

import com.ansdev.course_management_backend.models.mybatis.user.User;

import java.util.Optional;

public interface UserService {

    void  insert(User user);

    User getByEmail(String email);


}
