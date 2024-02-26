package com.polina.spring.rest.controller;

import com.polina.spring.rest.entity.Employee;
import com.polina.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable("id") int id) {
        return employeeService.getEmployee(id);
    }
    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable("id") int id) {
         employeeService.deleteEmployee(id);
    }
}
