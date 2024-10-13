package com.therap.supportplan.service;

import com.therap.supportplan.EmployeeRepository;
import com.therap.supportplan.model.Employee;
import com.therap.supportplan.model.EmployeeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author rokib.ahmed
 * @since 9/6/24
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee findById(long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);

//        employee.getBooks().forEach(address -> System.out.println(address.getTitle()));

        return employee;
    }

    @Transactional
    public Employee updateEmployee(Long employeeId, String newName) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        employee.setName(newName);

        List<EmployeeAddress> employeeAddresses = employee.getEmployeeAddresses();

        employeeAddresses.forEach(address -> {
            address.setTitle("employeeAddresse updated");
        });

        return employeeRepository.save(employee);
    }
}