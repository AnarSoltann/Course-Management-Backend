package com.ansdev.course_management_backend.repository;

import com.ansdev.course_management_backend.models.mybatis.subject.Subject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Optional;

@Mapper
public interface SubjectRepository {

    List<Subject> findAll();
    Optional<Subject> findById(@Param("id") Long id);
    void insert(Subject subject);
    void update (Subject subject);
}