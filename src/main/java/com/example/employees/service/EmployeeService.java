package com.example.employees.service;

import com.example.employees.model.Employee;
import com.example.employees.repository.EmployeeRepository;
import com.example.employees.repository.EmployeeRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee emp) {
        System.out.println("saved employee id: " + emp.getId());
        System.out.println("saved employee first name: " + emp.getFirstName());
        System.out.println("saved employee last name: " + emp.getLastName());
        System.out.println("saved employee email id: " + emp.getEmailId());
        return employeeRepository.save(emp);
    }

    // example of effectful method
    // method that changes the state an external / internal dependencies
    // some example of external dependencies include databases, servers, console
    // some example of internal dependencies include variable e.g. hashmap, arraylist
    public List<Employee> getAllEmployees() {
        System.out.println("get all employees: ");
        return employeeRepository.findAll();
    }

    public void deleteEmployeeById(Long empId) {
        System.out.println("delete employee by id: " + empId);
        employeeRepository.deleteById(empId);
    }

    public List<Employee> getEmployees(String lastName) {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Long empId, Employee employeeDetails) {
        Employee emp = employeeRepository.findById(empId).get();
        emp.setFirstName(employeeDetails.getFirstName());
        emp.setLastName(employeeDetails.getLastName());
        emp.setEmailId(employeeDetails.getEmailId());

        System.out.println("updating employee by id: " + emp.getId());
        System.out.println("new employee first name: " + emp.getFirstName());
        System.out.println("new employee last name: " + emp.getLastName());
        System.out.println("new employee email id: " + emp.getEmailId());
        return employeeRepository.save(emp);
    }

    public String getFirstNameById(Long id) {
        return employeeRepository.getFirstNameById(id);
    }

}
