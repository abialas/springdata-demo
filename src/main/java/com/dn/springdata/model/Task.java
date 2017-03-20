package com.dn.springdata.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by adam on 20.03.2017.
 */
@Entity
public class Task {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;

    private LocalDate timeCreate;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate closeDate;

    @ManyToMany
    private List<Employee> employees;


}
