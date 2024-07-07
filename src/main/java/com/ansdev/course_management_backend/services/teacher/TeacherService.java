package com.ansdev.course_management_backend.services.teacher;

import com.ansdev.course_management_backend.models.mybatis.teacher.Teacher;
import java.util.List;

public interface TeacherService {
    void insert(Teacher teacher);

    void update(Teacher teacher);

    Teacher findById(Long id);

    List<Teacher> findAll();
}