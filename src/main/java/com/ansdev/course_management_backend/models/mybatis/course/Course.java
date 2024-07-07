package com.ansdev.course_management_backend.models.mybatis.course;

import com.ansdev.course_management_backend.models.enums.course.CourseStatus;
import com.ansdev.course_management_backend.models.mybatis.base.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Course extends BaseEntity<Long> {
    String name;
    CourseStatus status;
}