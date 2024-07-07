package com.ansdev.course_management_backend.repository;

import com.ansdev.course_management_backend.models.mybatis.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.Optional;

@Mapper
public interface UserRepository {

    void insert(User user);

    void update(User user);

    Optional<User> findByEmail(@Param("email") String email);

    Optional<User> findById(@Param("id") Long id);

    Optional<User> findByPhoneNumber(@Param("phoneNumber") String phoneNumber);

}