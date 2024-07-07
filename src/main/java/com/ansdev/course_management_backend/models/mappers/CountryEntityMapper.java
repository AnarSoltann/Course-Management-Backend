package com.ansdev.course_management_backend.models.mappers;

import com.ansdev.course_management_backend.models.mybatis.country.Country;
import com.ansdev.course_management_backend.models.payload.country.CountryPayload;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CountryEntityMapper {
    CountryEntityMapper INSTANCE = Mappers.getMapper(CountryEntityMapper.class);
    Country toEntity(CountryPayload countryPayload);
    @Mapping(source = "id", target="id")
    Country toEntity(CountryPayload countryPayload, Long id);
}