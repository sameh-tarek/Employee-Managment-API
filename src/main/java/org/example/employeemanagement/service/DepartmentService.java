package org.example.employeemanagement.service;

import org.example.employeemanagement.entity.Department;
import org.example.employeemanagement.model.DepartmentRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartments();

    Page<Department> getAllDepartmentsByPages(Pageable pageable);

    Department getDepartmentDetailsById(Long id);

    String addNewDepartment(DepartmentRequestDTO departmentRequestDTO);

    String updateDepartment(DepartmentRequestDTO departmentRequestDTO, Long id);

    String deleteDepartment(Long id);

    List<Department> search(String query);
}
