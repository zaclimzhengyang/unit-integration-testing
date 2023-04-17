package com.example.employees;

import com.example.employees.repository.EmployeeRepository;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
//@RunWith(SpringRunner.class)
public class MockitoDemoApplicationTests {
//    @InjectMocks
//    private Employee testEmp;

//    @Autowired(required = true)
//    private EmployeeRepository employeeRepository;

    @Mock
    private EmployeeRepository employeeRepository;

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
//    @Test
//    public void whenUserIdIsProvided_thenRetrievedNameIsCorrect() {
//        Employee emp = new Employee();
//        emp.setFirstName("ZY");
//        Mockito.when(employeeRepositoryImp.getFirstNameById(007L)).thenReturn("ZY");
//        Employee testEmp = new Employee();
//        testEmp.setFirstName("ZY");
//        Assert.assertEquals("ZY", testEmp.getFirstName());
//    }

//    @Test
//    public void test_JUnit() {
//        System.out.println("This is the testcase in this class");
//        String str1 = "This is the testcase in this class";
//        assertEquals("This is the testcase in this class", str1);
//    }
}