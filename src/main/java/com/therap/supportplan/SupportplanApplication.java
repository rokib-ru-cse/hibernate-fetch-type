package com.therap.supportplan;

import com.therap.supportplan.model.Employee;
import com.therap.supportplan.model.EmployeeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SupportplanApplication implements CommandLineRunner {


    @Autowired
    EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(SupportplanApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        Employee employee = new Employee();
        employee.setName("New Employee");

        EmployeeAddress employeeAddress1 = new EmployeeAddress("new Address 1 Title");
        EmployeeAddress employeeAddress2 = new EmployeeAddress("new Address 2 Title");

        employee.getEmployeeAddresses().addAll(Arrays.asList(employeeAddress1, employeeAddress2));

        employeeRepository.save(employee);

        System.out.println("Employee data has been inserted.");
    }
}
