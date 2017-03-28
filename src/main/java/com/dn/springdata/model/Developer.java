package com.dn.springdata.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by adam on 18.03.2017.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Developer.findByExperienceLevel",
            query = "select d from Developer d where d.experienceLevel = ?1"),
        @NamedQuery(name = "Developer.findSalaryForDevsWithExperienceLevel",
            query = "select sum(d.salary) from Developer d where d.experienceLevel = ?1")
})
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
