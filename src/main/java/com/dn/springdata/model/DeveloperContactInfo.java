package com.dn.springdata.model;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by adam on 15.04.2017.
 */
public interface DeveloperContactInfo {

    String getFirstName();

    String getLastName();

    @Value("#{target.address.street}")
    String getStreet();

    @Value("#{target.address.city}")
    String getCity();
}
