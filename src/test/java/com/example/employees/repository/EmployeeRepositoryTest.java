package com.example.employees.repository;

import com.example.employees.config.RepositoryConfig;
import com.example.employees.model.Employee;
import com.example.employees.service.EmployeeService;
import com.example.employees.service.FortuneCookieService;
import jakarta.transaction.Transactional;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Repository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
//@DataJpaTest(includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Repository.class))
@Import(EmployeeRepository.class)
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testEmployeeRepository() {
        Employee employee = new Employee();
        employee.setId(100);
        employee.setFirstName("Classic");
        employee.setLastName("Coffee");
        employee.setEmailId("classicCoffee@gmail.com");
        employeeRepository.save(employee);

//        String testEmployeeFirstName = customEmployeeRepository.getFirstNameById(100);
//        Assert.assertEquals(testEmployeeFirstName, "Classic");
    }
}
