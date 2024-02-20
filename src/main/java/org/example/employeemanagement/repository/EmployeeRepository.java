package org.example.employeemanagement.repository;

import org.example.employeemanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartmentId(Long id);

    List<Employee> findByFirstNameContainingIgnoreCase(String query);
}
