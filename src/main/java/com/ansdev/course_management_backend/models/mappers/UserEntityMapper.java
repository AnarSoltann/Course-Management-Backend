package com.ansdev.course_management_backend.models.mappers;

import com.ansdev.course_management_backend.models.mybatis.user.User;
import com.ansdev.course_management_backend.models.payload.auth.signup.SignUpPayload;
import com.ansdev.course_management_backend.models.payload.student.StudentPayload;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserEntityMapper {

    UserEntityMapper INSTANCE = Mappers.getMapper(UserEntityMapper.class);

    @Mapping(target = "password", source = "encryptedPassword")
    @Mapping(target = "status", constant = "ACTIVE")
    @Mapping(target = "roleId", source = "roleId")
    User fromSignUpPayloadToUser(SignUpPayload payload, String encryptedPassword, Long roleId);

    @Mapping(target = "password", source = "encryptedPassword")
    @Mapping(target = "status", constant = "ACTIVE")
    @Mapping(target = "roleId", source = "roleId")
    User fromStudentPayloadToUser(StudentPayload studentPayload, String encryptedPassword, Long roleId);

}