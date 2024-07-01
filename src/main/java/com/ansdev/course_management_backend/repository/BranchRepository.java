package com.ansdev.course_management_backend.repository;

import com.ansdev.course_management_backend.models.mybatis.branch.Branch;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BranchRepository {

    void insert(Branch branch);
}
