package com.ansdev.course_management_backend.services.subject;

import com.ansdev.course_management_backend.models.payload.subject.SubjectPayload;

public interface SubjectBusinessService {
    void insertSubject(SubjectPayload subjectPayload);

    void editSubject(long id,SubjectPayload subjectPayload);
}