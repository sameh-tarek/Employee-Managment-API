package org.example.employeemanagement.mapper.impl;

import lombok.RequiredArgsConstructor;
import org.example.employeemanagement.entity.Employee;
import org.example.employeemanagement.exception.RecordNotFoundException;
import org.example.employeemanagement.mapper.EmployeeMapper;
import org.example.employeemanagement.model.EmployeeRequestDTO;
import org.example.employeemanagement.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeMapperImpl implements EmployeeMapper {

    private final DepartmentRepository departmentRepository;

    @Override
    public EmployeeRequestDTO toDTO(Employee employee) {
        EmployeeRequestDTO employeeRequestDTO = new EmployeeRequestDTO();
        employeeRequestDTO.setFirstName(employee.getFirstName());
        employeeRequestDTO.setLastName(employee.getLastName());
        employeeRequestDTO.setSalary(employee.getSalary());
        employeeRequestDTO.setDepartmentId(employee.getDepartment().getId());
        return employeeRequestDTO;
    }

    @Override
    public Employee toEntity(EmployeeRequestDTO employeeRequestDTO) {
        Employee employee1 = new Employee();
        employee1.setFirstName(employeeRequestDTO.getFirstName());
        employee1.setLastName(employeeRequestDTO.getLastName());
        employee1.setDepartment(departmentRepository.findById(employeeRequestDTO.getDepartmentId())
                .orElseThrow(() -> new RecordNotFoundException("this Department with id: " + employeeRequestDTO.getDepartmentId() + "Doesn't exist")));
        employee1.setSalary(employeeRequestDTO.getSalary());
        return employee1;
    }
}
