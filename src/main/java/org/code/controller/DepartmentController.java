package org.code.controller;

import org.code.entity.Department;
import org.code.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired private DepartmentService departmentService;

    // Save operation
    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    // Read operation
    @GetMapping("/departments")
    public ResponseEntity<List<Department>> fetchDepartmentList() {
        return new ResponseEntity<List<Department>>(departmentService.fetchDepartmentList(), HttpStatus.OK);
    }

    // Update operation
    @PutMapping("/departments/{id}")
    public Department updateDepartment(
            @RequestBody Department department,
            @PathVariable("id") Long departmentId
    ) {
        return departmentService.updateDepartment(department, departmentId);
    }

    // Delete operation
    @DeleteMapping("/departments/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteDepartmentById(
        @PathVariable("id") Long departmentId
    ) {
        departmentService.deleteDepartmentById(departmentId);
        return "Deleted Successfully";
    }
}
