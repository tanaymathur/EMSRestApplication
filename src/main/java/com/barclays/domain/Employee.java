package com.barclays.domain;

import com.barclays.View;
import com.fasterxml.jackson.annotation.JsonView;


/**
 * Created by knight on 14-12-2016.
 */
public class Employee {

    @JsonView(View.Summary.class)
    private String name;

    private Long id;


    @JsonView(View.Summary.class)
    private String role;


    public Employee() {
    }

    public Employee(String name, Long id, String role) {
        this.name = name;
        this.id = id;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
