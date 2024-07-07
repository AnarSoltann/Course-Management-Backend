package com.ansdev.course_management_backend.models.mappers;

import com.ansdev.course_management_backend.models.payload.subject.SubjectPayload;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import com.ansdev.course_management_backend.models.mybatis.subject.Subject;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubjectEntityMapper {
    SubjectEntityMapper INSTANCE = Mappers.getMapper(SubjectEntityMapper.class);

    @Mapping(target = "courseId", source = "courseId")
    Subject fromSubjectPayload(SubjectPayload subjectRequestDto, Long courseId);

    @Mapping(source = "id", target="id")
    Subject toEntity (SubjectPayload subjectPayload, long id);
}