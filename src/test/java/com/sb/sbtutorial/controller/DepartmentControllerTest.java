package com.sb.sbtutorial.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.sb.sbtutorial.entity.Department;
import com.sb.sbtutorial.service.DepartmentService;

@WebMvcTest(DepartmentController.class)
public class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
            .departmentAdress("Murcia")
            .departmentCode("IT-09")
            .departmentName("IT")
            .departmentId(1L)
            .build();
    }

    @Test
    void testFetchDepartmentById() throws Exception {

        Mockito.when(departmentService.fetchDepartmentById(1L))
            .thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.get("/departments/1")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName")
                .value(department.getDepartmentName()));
            

    }

    @Test
    void testSavDepartment() throws Exception {
        Department inputDepartment = Department.builder()
            .departmentAdress("Murcia")
            .departmentCode("IT-09")
            .departmentName("IT")
            .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment))
            .thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
            .contentType(MediaType.APPLICATION_JSON)
            .content(
                "{\n  \"departmentName\":\"IT\",\n  \"departmentAdress\":\"Murcia\",\n  \"departmentCode\":\"IT-09\"\n}"
            ))
            .andExpect(MockMvcResultMatchers.status().isOk());

    }


}
