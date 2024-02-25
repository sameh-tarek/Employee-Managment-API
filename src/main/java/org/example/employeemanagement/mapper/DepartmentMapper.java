package org.example.employeemanagement.mapper;

import org.example.employeemanagement.entity.Department;
import org.example.employeemanagement.model.DepartmentRequestDTO;

public interface DepartmentMapper {
    public DepartmentRequestDTO toDTO(Department department);
    public Department toEntity(DepartmentRequestDTO departmentRequestDTO);
}
