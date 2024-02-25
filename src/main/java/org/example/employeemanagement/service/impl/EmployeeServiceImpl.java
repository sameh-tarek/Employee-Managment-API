package org.example.employeemanagement.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.employeemanagement.entity.Employee;
import org.example.employeemanagement.exception.RecordNotFoundException;
import org.example.employeemanagement.mapper.EmployeeMapper;
import org.example.employeemanagement.model.EmployeeRequestDTO;
import org.example.employeemanagement.repository.EmployeeRepository;
import org.example.employeemanagement.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    @Override
    public List<Employee> listAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        log.info("All Employees : {}", employees);
        return employees;
    }

    @Override
    public Page<Employee> listAllEmployeesByPages(Pageable pageable) {
        Page<Employee> employees = employeeRepository.findAll(pageable);
        log.info("All Employees Pages : {}", employees);
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

    @Override
    public String addEmployee(EmployeeRequestDTO employeeRequestDTO) {
        log.info("You want to add Employee : {}", employeeRequestDTO);
        Employee employee = employeeMapper.toEntity(employeeRequestDTO);
        employeeRepository.save(employee);
        log.info("Employee Added successfully : {}", employee);
        return "success";
    }

    @Override
    public List<Employee> search(String query) {
        log.info("You want to search for Employees with query: {}", query);
        List<Employee> employees = employeeRepository.findByFirstNameContainingIgnoreCase(query);
        log.info("Employees from search : {}", employees);
        return employees;
    }

    @Override
    public String updateEmployee(EmployeeRequestDTO employeeRequestDTO, Long id) {
        Employee existEmployee = employeeRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("This Employee with Id "+ id + "Doesn't Exist"));
        Employee updatedEmployee = employeeMapper.toEntity(employeeRequestDTO);
        updatedEmployee.setId(id);
        log.info("You want to update employee with id: {}, from: {}, to: {}", id, existEmployee, updatedEmployee);
        employeeRepository.save(updatedEmployee);
        log.info("Employee updated successfully : {}", updatedEmployee);
        return "success";
    }

    @Override
    public String deleteEmployee(Long id) {
        log.info("You want to delete Employee with id {}", id);
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("This Employee with id " + id + "Already doesn't Exist"));
        employeeRepository.delete(employee);
        log.info("this Employee Deleted successfully: {}", employee);
        return "success";
    }

}
