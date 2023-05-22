package com.sb.sbtutorial.service;

import java.util.List;

import com.sb.sbtutorial.entity.Department;

public interface DepartmentService {

    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentId);
    
}
