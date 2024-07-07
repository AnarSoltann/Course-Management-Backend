package com.ansdev.course_management_backend.models.mappers;

import com.ansdev.course_management_backend.models.mybatis.appconfig.AppConfig;
import com.ansdev.course_management_backend.models.response.appconfig.AppConfigResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface AppConfigEntityMapper {

    AppConfigEntityMapper INSTANCE = Mappers.getMapper(AppConfigEntityMapper.class);

    AppConfigResponse fromEntityToPayload (AppConfig appConfig);

    List<AppConfigResponse> fromEntityToPayload (List<AppConfig> appConfigs);

}