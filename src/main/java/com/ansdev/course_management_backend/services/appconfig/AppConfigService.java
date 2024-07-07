package com.ansdev.course_management_backend.services.appconfig;

import com.ansdev.course_management_backend.models.mybatis.appconfig.AppConfig;

import java.util.List;

public interface AppConfigService {

    List<AppConfig> findAll();

    AppConfig findById(Long id);

    void insert(AppConfig appConfig);

    void update(AppConfig appConfig);
}