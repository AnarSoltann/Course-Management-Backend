package com.ansdev.course_management_backend.models.dto;


import com.ansdev.course_management_backend.models.mybatis.user.User;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class RefreshTokenDto {

    boolean rememberMe;

    User user;



}
