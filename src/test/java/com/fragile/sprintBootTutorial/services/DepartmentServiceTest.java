package com.fragile.sprintBootTutorial.services;

import com.fragile.sprintBootTutorial.entities.Department;
import com.fragile.sprintBootTutorial.respository.DepartmentRespository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    DepartmentService departmentService;

    @MockBean
    DepartmentRespository departmentRespository;
    @BeforeEach
    void setUp() {
    Department  department = Department.builder()
            .departmentName("CSC")
            .departmentAddress("CSC-200")
            .departmentCode("201")
            .departmentId(1L)
            .build();
        Mockito.when(departmentRespository.findByDepartmentNameIgnoreCase(department.getDepartmentName())).thenReturn(department);
    }
    @Test
    @DisplayName("Get data base on valid department name")
    public  void whenValidDepartmentName_thenDepartmentFound(){
        String departmentName = "CSC";
        Department found = departmentService.fetchDepartmentByName(departmentName);
         assertEquals(departmentName, found.getDepartmentName());
    }
}