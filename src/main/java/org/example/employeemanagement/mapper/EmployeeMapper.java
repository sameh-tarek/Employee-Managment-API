package org.example.employeemanagement.mapper;

import org.example.employeemanagement.entity.Employee;
import org.example.employeemanagement.model.EmployeeRequestDTO;

public interface EmployeeMapper {
    public EmployeeRequestDTO toDTO(Employee employee);
    public Employee toEntity(EmployeeRequestDTO employeeRequestDTO);
}
