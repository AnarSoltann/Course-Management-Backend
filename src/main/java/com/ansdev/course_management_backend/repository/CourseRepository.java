package com.ansdev.course_management_backend.repository;

import com.ansdev.course_management_backend.models.mybatis.course.Course;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseRepository {

    void insert(Course course);

}
