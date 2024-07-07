package com.ansdev.course_management_backend.models.payload.group;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupPayload {
    String name;
}