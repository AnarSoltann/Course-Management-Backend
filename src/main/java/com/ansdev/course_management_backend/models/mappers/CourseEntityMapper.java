
package com.ansdev.course_management_backend.models.mappers;

import com.ansdev.course_management_backend.models.mybatis.course.Course;
import com.ansdev.course_management_backend.models.payload.auth.signup.SignUpPayload;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface CourseEntityMapper {

    CourseEntityMapper INSTANCE = Mappers.getMapper(CourseEntityMapper.class);
    @Mapping(target = "name",source = "courseName")
    @Mapping(target = "status",constant = "ACTIVE")
    Course fromSignUpPayload(SignUpPayload signUpPayLoad);
}
