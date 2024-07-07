package com.ansdev.course_management_backend.services.userconfig;

import com.ansdev.course_management_backend.models.mybatis.userconfig.UserConfig;
import java.util.List;

public interface UserConfigService {

    void insert(UserConfig userConfig);
    UserConfig findByIdAndUserId(String id, Long userId);

    List<UserConfig> findAll();

    void update(UserConfig userConfig);

    void updateUserLanguage(Long userId, String langId);
}