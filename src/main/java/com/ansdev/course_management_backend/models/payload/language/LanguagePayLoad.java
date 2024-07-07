package com.ansdev.course_management_backend.models.payload.language;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LanguagePayLoad {

    String name;
    String icon;
}