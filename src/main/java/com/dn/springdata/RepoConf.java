package com.dn.springdata;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/**
 * Created by adam on 20.03.2017.
 */
@Configuration
@EnableJpaRepositories(namedQueriesLocation = "classpath:jpa-named-queries.properties")
public class RepoConf {
}