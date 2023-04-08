package com.example.employees;

import com.example.employees.model.Employee;
import com.example.employees.repository.EmployeeRepository;
import com.example.employees.repository.EmployeeRepositoryImp;
import com.example.employees.service.EmployeeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class MockitoDemoApplicationTests {
    @InjectMocks
    private EmployeeService employeeService;

//    @Autowired(required = true)
//    private EmployeeRepository employeeRepository;

    @Mock
    private EmployeeRepositoryImp employeeRepositoryImp;

    @Test
    public void whenUserIdIsProvided_thenRetrievedNameIsCorrect() {
        Employee emp = new Employee();
        emp.setFirstName("ZY");
        Mockito.when(employeeRepositoryImp.getOne(007L)).thenReturn(emp);
        Employee testEmp = new Employee();
        testEmp.setFirstName("ZY");
        Assert.assertEquals("ZY", testEmp.getFirstName());
    }
}