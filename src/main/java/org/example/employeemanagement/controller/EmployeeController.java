package org.example.employeemanagement.controller;

import lombok.RequiredArgsConstructor;
import org.example.employeemanagement.entity.Employee;
import org.example.employeemanagement.model.EmployeeRequestDTO;
import org.example.employeemanagement.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/pages")
    public Page<Employee> listAllEmployeesByPages(Pageable pageable){
        return employeeService.listAllEmployeesByPages(pageable);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeDetailsById(@PathVariable(name = "id") Long id){
        return employeeService.getEmployeeDetailsById(id);
    }

    @GetMapping("/department/{id}")
    public List<Employee> getEmployeesByDepartmentId(@PathVariable(name = "id") Long id){
        return employeeService.getEmployeesByDepartmentId(id);
    }

    @PostMapping("/add")
    public String addEmployee(@RequestBody @Validated EmployeeRequestDTO employeeRequestDTO){
        return employeeService.addEmployee(employeeRequestDTO);
    }

    @GetMapping("/search")
    public List<Employee> search(@RequestParam String query){
        return employeeService.search(query);
    }

    @PutMapping("/update/{id}")
    public String updateEmployee(@RequestBody @Validated EmployeeRequestDTO employeeRequestDTO, @PathVariable(name = "id") Long id){
        return employeeService.updateEmployee(employeeRequestDTO , id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable(name = "id") Long id){
        return employeeService.deleteEmployee(id);
    }

}
