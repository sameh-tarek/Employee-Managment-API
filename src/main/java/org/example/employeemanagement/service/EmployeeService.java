package org.example.employeemanagement.service;

import org.example.employeemanagement.entity.Employee;
import org.example.employeemanagement.model.EmployeeRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {

    List<Employee> listAllEmployees();

    Employee getEmployeeDetailsById(Long id);

    List<Employee> getEmployeesByDepartmentId(Long id);

    String addEmployee(EmployeeRequestDTO employeeRequestDTO);

    Page<Employee> listAllEmployeesByPages(Pageable pageable);

    String updateEmployee(EmployeeRequestDTO employeeRequestDTO, String id);

    List<Employee> search(String query);
}
