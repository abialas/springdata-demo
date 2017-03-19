package com.dn.springdata.model;

/**
 * Created by adam on 18.03.2017.
 */
public enum ProgrammingLanguage {
    JAVA("JAVA"),
    C("C"),
    C_SHARP("C#"),
    PYTHON("PYTHON");

    private String name;

    ProgrammingLanguage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
