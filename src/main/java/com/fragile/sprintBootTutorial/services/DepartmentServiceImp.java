package com.fragile.sprintBootTutorial.services;

import com.fragile.sprintBootTutorial.entities.Department;
import com.fragile.sprintBootTutorial.respository.DepartmentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    DepartmentRespository departmentRespository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRespository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRespository.findAll();
    }

    @Override
    public Department getDepartmentById(long deparmementId) {
        return departmentRespository.findById(deparmementId).get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRespository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartmentById(Long departmentId, Department department) {
        Department deptDB = departmentRespository.findById(departmentId).get();

        if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
            deptDB.setDepartmentName(department.getDepartmentName());
        }

        if (Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            deptDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
            deptDB.setDepartmentCode(department.getDepartmentCode());
        }
        departmentRespository.save(deptDB);
        return deptDB;
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRespository.findByDepartmentNameIgnoreCase(departmentName);
    }



//
}
