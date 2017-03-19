package com.dn.springdata.model;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.List;

/**
 * Created by adam on 18.03.2017.
 */
@Entity
public class Developer extends Employee {

    @ElementCollection
    private List<ProgrammingLanguage> programmingLanguages;

    public Developer() {
        super(EmployeePosition.DEVELOPER);
    }

    public List<ProgrammingLanguage> getProgrammingLanguages() {
        return programmingLanguages;
    }

    public void setProgrammingLanguages(List<ProgrammingLanguage> programmingLanguages) {
        this.programmingLanguages = programmingLanguages;
    }
}
