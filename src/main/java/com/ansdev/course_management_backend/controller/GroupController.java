package com.ansdev.course_management_backend.controller;

import com.ansdev.course_management_backend.models.base.BaseResponse;
import com.ansdev.course_management_backend.models.mappers.GroupEntityMapper;
import com.ansdev.course_management_backend.models.payload.group.GroupPayload;
import com.ansdev.course_management_backend.services.group.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @PostMapping
    public BaseResponse<Void> addGroup (@RequestBody GroupPayload groupPayload){
        groupService.insert(GroupEntityMapper.INSTANCE.toEntity(groupPayload));
        return BaseResponse.success();
    }

    @PutMapping("/{id}")
    public BaseResponse<Void> updateGroup (@PathVariable("id") long id, @RequestBody GroupPayload groupPayload) {
        groupService.update(GroupEntityMapper.INSTANCE.toEntity(groupPayload, id));
        return BaseResponse.success();
    }
}