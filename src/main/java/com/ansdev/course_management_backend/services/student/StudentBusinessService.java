package com.ansdev.course_management_backend.services.student;

import com.ansdev.course_management_backend.models.payload.student.StudentPayload;

public interface StudentBusinessService {

    void addStudent(StudentPayload studentPayload);

    void addStudentToGroup(long studentId, long groupId);
}