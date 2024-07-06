package com.ansdev.course_management_backend.services.employee;

import com.ansdev.course_management_backend.models.mybatis.employee.Employee;
import com.ansdev.course_management_backend.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Override
    public void insert(Employee employee) {
        employeeRepository.insert(employee);
    }
}
