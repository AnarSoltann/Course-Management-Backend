package com.ansdev.course_management_backend.controller;

import com.ansdev.course_management_backend.models.base.BaseResponse;
import com.ansdev.course_management_backend.models.payload.student.StudentPayload;
import com.ansdev.course_management_backend.services.student.StudentBusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentBusinessService studentBusinessService;

    @PostMapping
    public BaseResponse<Void> addStudent(@RequestBody StudentPayload studentPayload) {
        studentBusinessService.addStudent(studentPayload);
        return BaseResponse.success();

    }

    @PostMapping("/{id}/groups/{groupId}")
    public BaseResponse<Void> addStudentToGroup(@PathVariable("id") long studentId,
                                                @PathVariable("groupId") long groupId){
        studentBusinessService.addStudentToGroup(studentId, groupId);
        return BaseResponse.success();
    }
}