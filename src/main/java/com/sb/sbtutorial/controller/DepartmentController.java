package com.sb.sbtutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sb.sbtutorial.entity.Department;
import com.sb.sbtutorial.service.DepartmentService;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department savDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }
    
}
