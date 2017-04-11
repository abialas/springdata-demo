package com.dn.springdata.repo.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by adam on 04.04.2017.
 */
public class DeveloperRepositoryImpl implements CustomDeveloperRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public String findMostPopularFirstName() {
        Query query = entityManager.createQuery("select d.firstName " +
                "from Developer d " +
                "group by d.firstName " +
                "order by count(d.firstName) desc ")
                .setMaxResults(1);

        return (String) query.getSingleResult();
    }
}
