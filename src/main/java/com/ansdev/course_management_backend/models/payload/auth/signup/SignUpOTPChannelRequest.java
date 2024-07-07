package com.ansdev.course_management_backend.models.payload.auth.signup;

import com.ansdev.course_management_backend.models.common.proceedkey.ProceedKey;
import com.ansdev.course_management_backend.models.enums.otp.OTPChannel;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class SignUpOTPChannelRequest extends ProceedKey {

    private OTPChannel channel;

}