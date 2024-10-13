package com.therap.supportplan.model;

import javax.validation.Valid;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.persistence.FetchType.EAGER;

/**
 * @author rokib.ahmed
 * @since 9/6/24
 */
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Valid
    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(
            name = "employee_address",
            joinColumns = @JoinColumn(name = "employee_id"),
            indexes = @Index(columnList = "idx")
    )
    @OrderColumn(name = "idx")
    private List<EmployeeAddress> employeeAddresses;

    private Date created;

    private Date updated;

    public Employee() {
        this.employeeAddresses = new ArrayList<>();
    }

    @PrePersist
    public void createdDate() {
        created = new Date();
    }

    @PreUpdate
    public void updatedDate() {
        updated = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EmployeeAddress> getEmployeeAddresses() {
        return employeeAddresses;
    }

    public void setEmployeeAddresses(List<EmployeeAddress> employeeAddresses) {
        this.employeeAddresses = employeeAddresses;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
