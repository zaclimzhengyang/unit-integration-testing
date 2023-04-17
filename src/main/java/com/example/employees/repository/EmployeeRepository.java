package com.example.employees.repository;

import com.example.employees.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT a.firstName FROM employee WHERE a.empId = empId")
    public String getFirstNameById(@Param("id") Long empId);
}
