package com.ansdev.course_management_backend.models.mybatis.base;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;


@Data
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class BaseEntity extends IsDeletedEntity {

    Long id;

}
