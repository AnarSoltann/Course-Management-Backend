package com.ansdev.course_management_backend.models.mappers;

import com.ansdev.course_management_backend.models.mybatis.user.User;
import com.ansdev.course_management_backend.models.payload.auth.signup.SignUpPayload;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface UserEntityMapper {

    UserEntityMapper INSTANCE = Mappers.getMapper(UserEntityMapper.class);

    @Mapping(target = "password",source = "encryptedPassword")
    @Mapping(target="status",constant = "ACTIVE")
    @Mapping(target="roleId",source = "roleId")
    User fromSignUpPayLoadToUser(SignUpPayload signUpPayLoad, String encryptedPassword, Long roleId);


}