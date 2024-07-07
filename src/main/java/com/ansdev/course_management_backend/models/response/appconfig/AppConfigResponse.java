package com.ansdev.course_management_backend.models.response.appconfig;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppConfigResponse {
    String value;
    String description;
}