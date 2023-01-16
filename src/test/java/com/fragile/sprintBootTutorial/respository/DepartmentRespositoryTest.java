package com.fragile.sprintBootTutorial.respository;

import com.fragile.sprintBootTutorial.entities.Department;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class DepartmentRespositoryTest {

    @Autowired
    private DepartmentRespository departmentRespository;

    @Autowired
    private TestEntityManager entityManager;
    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("Mathematics")
                .departmentAddress("MTS-123")
                .departmentCode("123")
                .departmentId(1L)
                .build();
        entityManager.persist(department); // those will save this in database temporarily and flush immediately after testing

    }

    @Test
    @DisplayName("Get data based on valid id")
    public void whenfindById_thenReturnDepartment(){
        Department dept = departmentRespository.findById(1L).get();
        assertEquals(dept.getDepartmentName(), "Mathematics");

    }
}