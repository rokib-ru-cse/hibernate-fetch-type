package com.therap.supportplan;

import com.therap.supportplan.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author rokib.ahmed
 * @since 9/6/24
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}