package com.ansdev.course_management_backend.exception.types;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Map;

@Data
@Builder(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = lombok.AccessLevel.PRIVATE)
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class NotFoundExceptionType {


    String target;
    Map<String, Object> fields;

    public static NotFoundExceptionType of(String target, Map<String, Object> fields){
        return NotFoundExceptionType.builder()
                .target(target)
                .fields(fields)
                .build();
    }
}
