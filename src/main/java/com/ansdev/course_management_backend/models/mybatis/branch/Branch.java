package com.ansdev.course_management_backend.models.mybatis.branch;

import com.ansdev.course_management_backend.models.enums.branch.BranchStatus;
import com.ansdev.course_management_backend.models.mybatis.base.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Branch extends BaseEntity {

        String name;
        BranchStatus status;
        String address;
        Double lat;
        Double lon;
        Long courseId;

}
