package org.example.employeemanagement.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.employeemanagement.entity.Employee;
import org.example.employeemanagement.exception.RecordNotFoundException;
import org.example.employeemanagement.repository.EmployeeRepository;
import org.example.employeemanagement.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    @Override
    public List<Employee> listAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        log.info("All Employees : {}", employees);
        return employees;
    }

    @Override
    public Employee getEmployeeDetailsById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Employee with id: " + id + " doesn't exist"));
        log.info("Employee with ID {} Details : {}", id, employee);
        return employee;
    }

    @Override
    public List<Employee> getEmployeesByDepartmentId(Long id) {
        List<Employee> employees = employeeRepository.findByDepartmentId(id);
        log.info("All Employees in Department with id {} is :  {}", id, employees);
        return employees;
    }

}
