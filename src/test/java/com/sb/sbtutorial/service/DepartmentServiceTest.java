package com.sb.sbtutorial.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sb.sbtutorial.entity.Department;
import com.sb.sbtutorial.repository.DepartmentRepository;

@SpringBootTest
public class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository repository;

    @BeforeEach // it will be called before each test cases
    void setUp() {
        Department department = Department.builder()
            .departmentName("IT")
            .departmentAdress("Madrid")
            .departmentCode("IT-001")
            .departmentId(1L)
            .build();

        Mockito.when(repository.findByDepartmentNameIgnoreCase("IT"))
            .thenReturn(department);
    }

    @Test
    @DisplayName("Get Data based on valid Department Name")
    public void ifValidDepartmentName_thenDepartmentShouldFound() {
        String departmentName = "IT";
        Department found = departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartmentName());
    }

}
