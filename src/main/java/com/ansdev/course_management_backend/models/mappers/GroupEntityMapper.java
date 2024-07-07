package com.ansdev.course_management_backend.models.mappers;

import com.ansdev.course_management_backend.models.mybatis.group.Group;
import com.ansdev.course_management_backend.models.payload.group.GroupPayload;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GroupEntityMapper {

    GroupEntityMapper INSTANCE = Mappers.getMapper(GroupEntityMapper.class);

    Group toEntity (GroupPayload groupPayload);

    @Mapping(source = "id", target="id")
    Group toEntity (GroupPayload groupPayload, Long id);

}