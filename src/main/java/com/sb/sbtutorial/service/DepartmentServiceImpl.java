package com.sb.sbtutorial.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.sbtutorial.entity.Department;
import com.sb.sbtutorial.error.DepartmentNotFoundException;
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
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = repository.findById(departmentId);

        if (!department.isPresent()) {
            throw new DepartmentNotFoundException("Department Not Available");
        }

        return department.get();

    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        repository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department depDB = repository.findById(departmentId).get();

        if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
            depDB.setDepartmentName(department.getDepartmentName());
        }

        if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
            depDB.setDepartmentName(department.getDepartmentCode());
        }

        if (Objects.nonNull(department.getDepartmentAdress()) && !"".equalsIgnoreCase(department.getDepartmentAdress())) {
            depDB.setDepartmentName(department.getDepartmentAdress());
        }

        return repository.save(depDB);
        
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return repository.findByDepartmentNameIgnoreCase(departmentName);
    }
    
}
