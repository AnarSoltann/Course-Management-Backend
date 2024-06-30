package com.ansdev.course_management_backend.services.user;

import com.ansdev.course_management_backend.models.mybatis.user.User;

public interface UserService {

    void  insert(User user);

    User getByEmail(String email);

    boolean checkByEmail(String email);


}
