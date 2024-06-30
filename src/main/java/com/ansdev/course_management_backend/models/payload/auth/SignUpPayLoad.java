package com.ansdev.course_management_backend.models.payload.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class SignUpPayLoad {

    String name;
    String surname;
    String email;
    String phoneNumber;
    String password;

    String CourseName;
    String address;


}
