package com.ansdev.course_management_backend.repository;

import com.ansdev.course_management_backend.models.mybatis.userconfig.UserConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Optional;

@Mapper
public interface UserConfigRepository {
    void insert(UserConfig userConfig);

    Optional<UserConfig> findByIdAndUserId(@Param("id") String id, @Param("userId") Long userId);

    List<UserConfig> findAll();

    void update(UserConfig userConfig);

    void updateConfig(@Param("id") String id, @Param("value") Object value, @Param("userId") Long userId);
}