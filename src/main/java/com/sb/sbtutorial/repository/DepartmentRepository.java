package com.sb.sbtutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sb.sbtutorial.entity.Department;

// How to create custom queries for JPA:
// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    
    public Department findByDepartmentName(String departmentName);
    public Department findByDepartmentNameIgnoreCase(String departmentName);

}
