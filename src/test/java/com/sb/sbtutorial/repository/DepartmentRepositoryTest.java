package com.sb.sbtutorial.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.sb.sbtutorial.entity.Department;

@DataJpaTest
public class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
            .departmentName("Mechanical Engineering")
            .departmentCode("ME - 011")
            .departmentAdress("Valencia")
            .build();

        entityManager.persist(department);

    }

    @Test
    public void whenFindById_thenReturnDepartment() {
        Department department = repository.findById(1L).get();

        assertEquals(department.getDepartmentName(), "Mechanical Engineering");
    }

}
