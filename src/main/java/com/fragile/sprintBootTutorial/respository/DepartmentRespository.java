package com.fragile.sprintBootTutorial.respository;

import com.fragile.sprintBootTutorial.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRespository extends JpaRepository<Department, Long> {
     Department findByDepartmentName(String departmentName);

     //ignore case check
     Department findByDepartmentNameIgnoreCase(String departmentName);


     }

