package com.ansdev.course_management_backend.models.mybatis.user;

import com.ansdev.course_management_backend.models.enums.user.UserStatus;
import com.ansdev.course_management_backend.models.mybatis.base.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {

    String name;
    String surname;
    String email;
    String phoneNumber;
    UserStatus status;
    Long roleId;
    String password;

    public boolean IsActive() {
        return UserStatus.ACTIVE.equals(status);
    }

}
