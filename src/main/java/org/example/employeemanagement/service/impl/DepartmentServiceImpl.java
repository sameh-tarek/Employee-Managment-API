package org.example.employeemanagement.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.employeemanagement.entity.Department;
import org.example.employeemanagement.exception.RecordNotFoundException;
import org.example.employeemanagement.mapper.DepartmentMapper;
import org.example.employeemanagement.model.DepartmentRequestDTO;
import org.example.employeemanagement.repository.DepartmentRepository;
import org.example.employeemanagement.service.DepartmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    @Override
    public List<Department> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        log.info("All Departments : {}", departments);
        return departments;
    }

    @Override
    public Page<Department> getAllDepartmentsByPages(Pageable pageable) {
        Page<Department> departments = departmentRepository.findAll(pageable);
        log.info("All Departments pages : {}", departments);
        return departments;
    }

    @Override
    public Department getDepartmentDetailsById(Long id) {
        log.info("you want to get Department Details By Id : {}", id);
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("This department with id " + id + "doesn't exist"));
        log.info("Department details : {}", department);
        return department;
    }

    @Override
    public String addNewDepartment(DepartmentRequestDTO departmentRequestDTO) {
        log.info("you want to add new Department {}", departmentRequestDTO);
        Department department = departmentMapper.toEntity(departmentRequestDTO);
        departmentRepository.save(department);
        log.info("Department Added Successfully: {}", department);
        return "success";
    }

    @Override
    public String updateDepartment(DepartmentRequestDTO departmentRequestDTO, Long id) {
        Department existDepartment = departmentRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("This Department with id: " + id + "doesn't exist"));
        Department updatedDepartment = departmentMapper.toEntity(departmentRequestDTO);
        updatedDepartment.setId(id);
        departmentRepository.save(updatedDepartment);
        log.info("You updated department with id: {}, from: {}, to {}", id, existDepartment, updatedDepartment);
        return "success";
    }

    @Override
    public String deleteDepartment(Long id) {
        log.info("You want to delete Department with id {}", id);
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("This Department with id " + id + "already doesn't exist"));
        departmentRepository.delete(department);
        log.info("this department Deleted successfully: {}", department);
        return "success";
    }

    @Override
    public List<Department> search(String query) {
        log.info("You want to search for Departments with query: {}", query);
        List<Department> departments = departmentRepository.findByNameContainingIgnoreCase(query);
        log.info("Departments from search: {}", departments);
        return departments;
    }

}
