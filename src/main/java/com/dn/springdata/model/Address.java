package com.dn.springdata.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by adam on 21.03.2017.
 */
@Entity
public class Address {

    @Id
    @GeneratedValue
    private Long id;
    private String city;
    private String street;
    @OneToOne
    private Employee employee;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
