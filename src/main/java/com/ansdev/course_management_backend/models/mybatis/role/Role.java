package com.ansdev.course_management_backend.models.mybatis.role;

import com.ansdev.course_management_backend.models.mybatis.base.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Role extends BaseEntity {

    String name;
    String description;
}
