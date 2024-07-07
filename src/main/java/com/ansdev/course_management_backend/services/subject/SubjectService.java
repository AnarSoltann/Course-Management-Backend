package com.ansdev.course_management_backend.services.subject;

import com.ansdev.course_management_backend.models.mybatis.subject.Subject;
import java.util.List;

public interface SubjectService {

    List<Subject> findAll();
    Subject findById(Long id);
    void  insert(Subject subject);
    void update (Subject subject);
}