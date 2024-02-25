package org.example.employeemanagement.mapper.impl;

import org.example.employeemanagement.entity.Department;
import org.example.employeemanagement.mapper.DepartmentMapper;
import org.example.employeemanagement.model.DepartmentRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapperImpl implements DepartmentMapper {
    @Override
    public DepartmentRequestDTO toDTO(Department department) {
        DepartmentRequestDTO departmentRequestDTO = new DepartmentRequestDTO();
        departmentRequestDTO.setName(department.getName());
        return departmentRequestDTO;
    }

    @Override
    public Department toEntity(DepartmentRequestDTO departmentRequestDTO) {
        Department department = new Department();
        department.setName(departmentRequestDTO.getName());
        return department;
    }
}
