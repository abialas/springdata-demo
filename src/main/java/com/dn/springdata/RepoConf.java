package com.dn.springdata;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by adam on 20.03.2017.
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.dn.springdata.repo.jpa", namedQueriesLocation = "classpath:jpa-named-queries.properties")
@EnableMongoRepositories(basePackages = "com.dn.springdata.repo.mongo")
public class RepoConf {
}