package com.ansdev.course_management_backend.services.group;
import com.ansdev.course_management_backend.exception.BaseException;
import com.ansdev.course_management_backend.models.mybatis.group.Group;
import com.ansdev.course_management_backend.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService{

    private final GroupRepository groupRepository;
    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public Group findById(Long id) {
        return groupRepository.findById(id).orElseThrow(
                ()-> BaseException.notFound(Group.class.getSimpleName(),"group",String.valueOf(id)));
    }

    @Override
    public void insert(Group group) {
        groupRepository.insert(group);

    }

    @Override
    public void update(Group group) {
        groupRepository.update(group);

    }
}