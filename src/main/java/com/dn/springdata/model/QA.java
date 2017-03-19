package com.dn.springdata.model;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.List;

/**
 * Created by adam on 18.03.2017.
 */
@Entity
public class QA extends Employee {

    @ElementCollection
    private List<TestFrameworks> testFrameworks;

    public QA() {
        super(EmployeePosition.QA);
    }

    public List<TestFrameworks> getTestFrameworks() {
        return testFrameworks;
    }

    public void setTestFrameworks(List<TestFrameworks> testFrameworks) {
        this.testFrameworks = testFrameworks;
    }
}
