package com.ansdev.course_management_backend.repository;


import com.ansdev.course_management_backend.models.mybatis.user.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {

    void insert(User user);

}
