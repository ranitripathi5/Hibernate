package com.map1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Project {
    @Id
    private int projectId;

    @Column(name="Project_name")
    private String project;

    @ManyToMany(mappedBy = "projects")
    private List<Employee> employees;

    public Project(int projectId, String project, List<Employee> employees) {
        super();
        this.projectId = projectId;
        this.project = project;
        this.employees = employees;
    }

    public Project() {
        super();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
}
