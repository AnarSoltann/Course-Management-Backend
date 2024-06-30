package com.ansdev.course_management_backend.services.role;

import com.ansdev.course_management_backend.exception.BaseException;
import com.ansdev.course_management_backend.models.mybatis.role.Role;
import com.ansdev.course_management_backend.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImpl implements RoleService{
    private final static String OWNER = "OWNER";
    private final RoleRepository roleRepository;

    @Override
    public Role getDefaultRole() {
        return roleRepository.findByName(OWNER).orElseThrow(BaseException::unexpected);
    }
}
