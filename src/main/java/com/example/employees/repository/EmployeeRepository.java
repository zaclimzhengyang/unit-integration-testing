package com.example.employees.repository;

import com.example.employees.model.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    /**
     *
     * @param empId
     * @return
     *
     * high level - Java Persistence API (JPA) is the standard API for accessing relational database,
     *              providing a simple and efficient way for managing the object-relational mapping (ORM)
     *              ORM is basically the bridge between OOP languages e.g. python, java, and RDBS, e.g. MySql
     *
     * things to note:
     * 1. when we use JPQL, it eliminates the need for us to use JDBC API, it basically does all the work under the hood
     *  e.g. we do not have to open connection, write statement, execute query, close connection etc
     *
     * JPQL vs
     *      @Query("SELECT u FROM User u WHERE u.status = :status and u.name = :name")
     *      User findUserByUserStatusAndUserName(@Param("status") Integer userStatus,
     *      @Param("name") String userName);
     * Native
     *      @Query(value = "SELECT * FROM Users u WHERE u.status = :status and u.name = :name",
     *      nativeQuery = true)
     *      User findUserByStatusAndNameNamedParamsNative(
     *      @Param("status") Integer status, @Param("name") String name);
     */

//    when using native SQL statement, we have to set nativeQuery to true
//    otherwise, JVM would treat it as a JPQL statement and therefore cause error
//    @Query("SELECT e FROM employee e WHERE e.empId = :empId")
    @Query(value = "SELECT first_name FROM employee  WHERE emp_id = :empId", nativeQuery = true)
    public String getFirstNameById(@Param("empId") Long empId);
}
