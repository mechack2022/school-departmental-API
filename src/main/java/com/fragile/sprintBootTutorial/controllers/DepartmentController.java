package com.fragile.sprintBootTutorial.controllers;

import com.fragile.sprintBootTutorial.entities.Department;
import com.fragile.sprintBootTutorial.services.DepartmentService;
import jakarta.persistence.PostUpdate;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);


    @PostMapping("/departments/add")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        return departmentService.saveDepartment(department);

    }

    @GetMapping("/departments")
    public List<Department> getAllADepartments() {
        LOGGER.info("The getAllADepartments from departmentController");
        return departmentService.getAllDepartments();
    }


    @GetMapping("/department/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId) {
        LOGGER.info("The getDepartmentById from departmentController");
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("/department/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        LOGGER.info("The deleteDepartmentById from departmentController");
        departmentService.deleteDepartmentById(departmentId);
        return "department successfully deleted";
    }
    @PutMapping("/department/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long departmentId, @RequestBody Department department){
        LOGGER.info("The updateDepartmentById from departmentController");
         return departmentService.updateDepartmentById(departmentId, department);
    }
   @GetMapping("/departments/names/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
       LOGGER.info("The fetchDepartmentByName from departmentController");
        return departmentService.fetchDepartmentByName(departmentName);
   }




}
