package com.fragile.sprintBootTutorial.services;

import com.fragile.sprintBootTutorial.entities.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);
    public List<Department> getAllDepartments();

    Department getDepartmentById(long departmentId);

    void deleteDepartmentById(Long departmentId);

    Department updateDepartmentById(Long departmentId, Department department);

    Department fetchDepartmentByName(String departmentName);
}
