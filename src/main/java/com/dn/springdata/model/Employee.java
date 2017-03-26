package com.dn.springdata.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by adam on 18.03.2017.
 */
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private EmployeePosition employeePosition;
    private LocalDate startDate;
    private LocalDate endDate;
    @ManyToMany(mappedBy = "employees")
    private List<Task> tasks;
    @Enumerated(EnumType.STRING)
    private ExperienceLevelEnum experienceLevel;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    private Employee() {
    }

    public Employee(EmployeePosition position) {
        this.employeePosition = position;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public EmployeePosition getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(EmployeePosition employeePosition) {
        this.employeePosition = employeePosition;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public ExperienceLevelEnum getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(ExperienceLevelEnum experienceLevel) {
        this.experienceLevel = experienceLevel;
    }
}
