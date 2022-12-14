package com.map1;

import javax.persistence.*;
import java.util.List;


@Entity
public class Employee {
    @Id
    private int empId;
    private String Employee;

    @ManyToMany
    @JoinTable(name="emp_learnings",
            joinColumns = {@JoinColumn (name="e_id")},
            inverseJoinColumns = {@JoinColumn (name="p_id")})
    private List<Project>projects;

    public Employee() {
        super();
    }

    public Employee(int empId, String employee, List<Project> projects) {
        super();
        this.empId = empId;
        Employee = employee;
        this.projects = projects;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmployee() {
        return Employee;
    }

    public void setEmployee(String employee) {
        Employee = employee;
    }
}
