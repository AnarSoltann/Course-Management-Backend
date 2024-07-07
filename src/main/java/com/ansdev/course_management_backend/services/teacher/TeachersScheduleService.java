package com.ansdev.course_management_backend.services.teacher;

import com.ansdev.course_management_backend.models.mybatis.teacher.TeachersSchedule;
import java.util.List;

public interface TeachersScheduleService {
    void insert(TeachersSchedule teachersSchedule);

    TeachersSchedule findById(Long id);

    List<TeachersSchedule> findAll();

    void update(TeachersSchedule teachersSchedule);
}