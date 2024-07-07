package com.ansdev.course_management_backend.services.user.settings;

import com.ansdev.course_management_backend.services.language.LanguageService;
import com.ansdev.course_management_backend.services.userconfig.UserConfigService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserSettingsBusinessServiceImpl implements UserSettingsBusinessService{

    private final LanguageService languageService;
    private final UserConfigService userConfigService;


    @Override
    public void updateUserDefaultLanguage(Long userId, String langId) {

        languageService.findById(Long.valueOf(langId));

        userConfigService.updateUserLanguage(userId,langId);
    }
}