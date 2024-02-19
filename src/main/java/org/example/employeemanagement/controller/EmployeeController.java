package org.example.employeemanagement.controller;

import lombok.RequiredArgsConstructor;
import org.example.employeemanagement.entity.Employee;
import org.example.employeemanagement.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> listAllEmployees(){
        return employeeService.listAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeDetailsById(@PathVariable(name = "id") Long id){
        return employeeService.getEmployeeDetailsById(id);
    }

    @GetMapping("/department/{id}")
    public List<Employee> getEmployeesByDepartmentId(@PathVariable(name = "id") Long id){
        return employeeService.getEmployeesByDepartmentId(id);
    }
}
