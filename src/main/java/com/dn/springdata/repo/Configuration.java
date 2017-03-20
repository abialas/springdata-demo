package com.dn.springdata.repo;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by adam on 20.03.2017.
 */
@EnableJpaRepositories(basePackages = "com.dn.springdata.repo")
//@EnableMongoRepositories(basePackages = "com.acme.repositories.mongo")
public interface Configuration {
}
