package org.example.employeemanagement.repository;

import org.example.employeemanagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends
        JpaRepository<Department, Long> {
    List<Department> findByNameContainingIgnoreCase(String name);
}
