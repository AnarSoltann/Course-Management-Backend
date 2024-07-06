package com.ansdev.course_management_backend.repository;

import com.ansdev.course_management_backend.models.mybatis.employee.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeRepository {

    void insert(Employee employee);
}
