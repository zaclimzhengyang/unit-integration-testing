package com.example.employees.repository;

import com.example.employees.config.RepositoryConfig;
import com.example.employees.model.Employee;
import com.example.employees.service.EmployeeService;
import com.example.employees.service.FortuneCookieService;
import jakarta.transaction.Transactional;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

//@RunWith(MockitoJUnitRunner.class)
//@DataJpaTest(includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Repository.class))
@DataJpaTest
@RunWith(SpringRunner.class)
//@SpringBootTest(classes=EmployeeRepository.class)
public class EmployeeRepositoryTest {
    /**
     * Why this repository service method, .getFirstNameById should be an integration test instead:
     * 1. The logic for making a database query here, is using springboot's DAO package.
     * This is open-sourced, and already extensively tested.
     * The only reason this will likely have a bug, is if the SQL query is malformatted / got bug
     *
     * 2. This method, is an effect; it makes a state change to your database (can be a variable / api service)
     * - This requires a database to even execute.
     * - This is best moved as an integration test; a test which tests two or more thins
     * - An integration test in this case will test both the database, and this method
     */

    @Mock
    private EmployeeRepository employeeRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testEmployeeRepository() {
        Long id = 100L;
        String expectedEmployeeFirstName = "Classic Cookie";

        when(employeeRepository.getFirstNameById(id)).thenReturn(expectedEmployeeFirstName);
        String actualEmployeeFirstName = employeeRepository.getFirstNameById(id);
        System.out.println(actualEmployeeFirstName);
        Assert.assertEquals(expectedEmployeeFirstName,actualEmployeeFirstName);
    }
}
