package org.example.employeemanagement.controller;

import lombok.RequiredArgsConstructor;
import org.example.employeemanagement.entity.Department;
import org.example.employeemanagement.model.DepartmentRequestDTO;
import org.example.employeemanagement.service.DepartmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("/pages")
    public Page<Department> getAllDepartmentsByPages(Pageable pageable){
        return departmentService.getAllDepartmentsByPages(pageable);
    }

    @GetMapping("/{id}")
    public Department getDepartmentDetailsById(@PathVariable(name = "id") Long id){
        return departmentService.getDepartmentDetailsById(id);
    }

    @PostMapping("/add")
    public String addNewDepartment(@RequestBody DepartmentRequestDTO departmentRequestDTO){
        return departmentService.addNewDepartment(departmentRequestDTO);
    }

    @PutMapping("/update/{id}")
    public String updateDepartment(@RequestBody DepartmentRequestDTO departmentRequestDTO, @PathVariable(name = "id") Long id){
        return departmentService.updateDepartment(departmentRequestDTO, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable(name = "id") Long id){
        return departmentService.deleteDepartment(id);
    }

    @GetMapping("/search")
    public List<Department> Search(@RequestParam String query){
        return departmentService.search(query);
    }
}
