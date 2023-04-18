package com.example.employees;

import com.example.employees.repository.EmployeeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
//@RunWith(SpringRunner.class)
public class MockitoDemoApplicationTests {

    @Test
    public void test_JUnit() {
        System.out.println("This is the testcase in this class");
        String str1 = "This is the testcase in this class";
        assertEquals("This is the testcase in this class", str1);
    }
}