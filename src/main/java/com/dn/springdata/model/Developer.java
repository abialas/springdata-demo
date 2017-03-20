package com.dn.springdata.model;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

/**
 * Created by adam on 18.03.2017.
 */
@Entity
public class Developer extends Employee {

    @ElementCollection
    private List<ProgrammingLanguage> programmingLanguages;

    @Enumerated(EnumType.STRING)
    private ExperienceLevelEnum experienceLevel;

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
