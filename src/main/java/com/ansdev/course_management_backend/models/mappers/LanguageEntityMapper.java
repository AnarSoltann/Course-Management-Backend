package com.ansdev.course_management_backend.models.mappers;

import com.ansdev.course_management_backend.models.mybatis.language.Language;
import com.ansdev.course_management_backend.models.payload.language.LanguagePayLoad;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LanguageEntityMapper {

    LanguageEntityMapper INSTANCE = Mappers.getMapper(LanguageEntityMapper.class);

    Language toEntity(LanguagePayLoad languagePayLoad);

    @Mapping(source = "id", target="id")
    Language toEntity(LanguagePayLoad languagePayLoad, Long id);
}