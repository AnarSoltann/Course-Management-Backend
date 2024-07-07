package com.ansdev.course_management_backend.services.user.settings;

public interface UserSettingsBusinessService {

    void updateUserDefaultLanguage(Long userId, String langId);
}