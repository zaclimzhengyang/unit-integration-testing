package com.example.employees.controller;

import com.example.employees.model.Employee;
import com.example.employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService empService;

    @RequestMapping(value="/employees", method= RequestMethod.POST)
    public Employee createEmployee(@RequestBody Employee emp) {
        return empService.createEmployee(emp);
    }

    @RequestMapping(value="/employees", method=RequestMethod.GET)
    public List<Employee> readAllEmployees () {
        return empService.getAllEmployees();
    }

    @RequestMapping(value="/employees/{empId}", method=RequestMethod.PUT)
    public Employee readEmployees(@PathVariable(value="empId") Long id, @RequestBody Employee empDetails) {
        return empService.updateEmployee(id, empDetails);
    }

    @RequestMapping(value="/employees/{empId}", method=RequestMethod.DELETE)
    public String deleteEmployees(@PathVariable(value="empId") Long id) {
        empService.deleteEmployeeById(id);
        return "deleted employee by id: " + id;
    }

}
