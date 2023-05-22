package com.sb.sbtutorial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.sbtutorial.entity.Department;
import com.sb.sbtutorial.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    @Override
    public Department saveDepartment(Department department) {
        return repository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return repository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) {
        return repository.findById(departmentId).get();
    }
    
}
