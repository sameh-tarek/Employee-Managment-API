package org.example.employeemanagement.mapper.impl;

import org.example.employeemanagement.entity.Employee;
import org.example.employeemanagement.mapper.EmployeeMapper;
import org.example.employeemanagement.model.EmployeeRequestDTO;
import org.example.employeemanagement.repository.DepartmentRepository;
import org.example.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMapperImpl implements EmployeeMapper {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public EmployeeRequestDTO toDTO(Employee employee) {
        EmployeeRequestDTO employeeRequestDTO = new EmployeeRequestDTO();
        employeeRequestDTO.setFirstName(employee.getFirstName());
        employeeRequestDTO.setLastName(employeeRequestDTO.getLastName());
        employeeRequestDTO.setSalary(employeeRequestDTO.getSalary());

        employeeRequestDTO.setDepartmentId(departmentRepository.findById(employee.getId()).orElse(null).getId());

        return employeeRequestDTO;
    }

    @Override
    public Employee toEntity(EmployeeRequestDTO employeeRequestDTO) {
        Employee employee1 = new Employee();
        employee1.setFirstName(employeeRequestDTO.getFirstName());
        employee1.setLastName(employeeRequestDTO.getLastName());
        employee1.setDepartment(departmentRepository.findById(employeeRequestDTO.getDepartmentId()).orElse(null));
        employee1.setSalary(employeeRequestDTO.getSalary());
        return employee1;
    }
}
