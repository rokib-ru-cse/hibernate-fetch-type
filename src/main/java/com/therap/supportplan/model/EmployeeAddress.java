package com.therap.supportplan.model;

import javax.persistence.*;

/**
 * @author rokib.ahmed
 * @since 9/6/24
 */
@Embeddable
public class EmployeeAddress {

    private String title;

    public EmployeeAddress() {
    }

    public EmployeeAddress(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
