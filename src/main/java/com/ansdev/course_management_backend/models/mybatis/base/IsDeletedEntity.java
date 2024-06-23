package com.ansdev.course_management_backend.models.mybatis.base;

import lombok.Data;
import lombok.experimental.FieldDefaults;


@Data
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class IsDeletedEntity {

    boolean isDeleted;
}

