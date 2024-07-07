package com.ansdev.course_management_backend.models.payload.student;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentPayload {

    //todo: validation
    String name;
    String surname;
    String email;
    String phoneNumber;

}