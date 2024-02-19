package org.example.employeemanagement.service;

import org.example.employeemanagement.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> listAllEmployees();

    Employee getEmployeeDetailsById(Long id);

    List<Employee> getEmployeesByDepartmentId(Long id);
}
