package com.dn.springdata;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by adam on 25.04.2017.
 */
@Configuration
public class QueryDSLConf {

    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public JPAQueryFactory getJPAQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }

}
