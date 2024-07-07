package com.ansdev.course_management_backend.services.group;

import com.ansdev.course_management_backend.models.mybatis.group.Group;
import java.util.List;

public interface GroupService {

    List<Group> findAll();
    Group findById(Long id);
    void insert(Group group);
    void  update(Group group);
}