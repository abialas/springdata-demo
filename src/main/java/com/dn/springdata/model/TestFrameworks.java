package com.dn.springdata.model;

/**
 * Created by adam on 18.03.2017.
 */
public enum TestFrameworks {
    RCPTT("RCPTT"),
    SELENIUM("SELENIUM"),
    ;

    private String name;

    TestFrameworks(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
