package com.ansdev.course_management_backend.models.mybatis.branch;

import com.ansdev.course_management_backend.models.enums.branch.BranchStatus;
import com.ansdev.course_management_backend.models.mybatis.base.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Branch extends BaseEntity<Long> {

        String name;
        BranchStatus status;
        String address;
        Double lat;
        Double lon;
        Long courseId;

}