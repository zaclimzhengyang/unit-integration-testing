package com.example.employees.repository;

import com.example.employees.model.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//    @Query("SELECT a.firstName FROM employee WHERE a.empId = :empId")
//    public String getFirstNameById(@Param("id") Integer empId);
}
