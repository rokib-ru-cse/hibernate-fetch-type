package com.therap.supportplan.controller;

import com.therap.supportplan.model.Employee;
import com.therap.supportplan.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rokib.ahmed
 * @since 9/6/24
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/get-employee")
    public Employee employee() {
        return employeeService.findById(1L);
    }

    @GetMapping("/update-employee")
    public Employee update_employee() {
        return employeeService.updateEmployee(1L, "Emplyee name updated");
    }
}
