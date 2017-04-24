package com.dn.springdata.repo.jpa;

import com.dn.springdata.model.Developer;
import com.dn.springdata.model.Developer_;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

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

    @Override
    public List<Developer> findDevelopersWithSalaryBiggerThanCriteriaQuery(double salary) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Developer> query = criteriaBuilder.createQuery(Developer.class);
        Root<Developer> root = query.from(Developer.class);

        Predicate salaryBiggerThan = criteriaBuilder.greaterThan(root.get("salary"), salary);
        query.where(salaryBiggerThan);

        return entityManager.createQuery(query.select(root)).getResultList();
    }

    @Override
    public List<Developer> findDevelopersWithSalaryBiggerThanCriteriaQueryWithMetaModel(double salary) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Developer> query = criteriaBuilder.createQuery(Developer.class);
        Root<Developer> root = query.from(Developer.class);

        Predicate salaryBiggerThan = criteriaBuilder.greaterThan(root.get(Developer_.salary), salary);
        query.where(salaryBiggerThan);

        return entityManager.createQuery(query.select(root)).getResultList();
    }

    @Override
    public List<Developer> findDevelopersWithSalaryBiggerThanJPQL(double salary) {
        Query query = entityManager.createQuery("select d from Developer d where d.salary > :salary", Developer.class);
        query.setParameter("salary", salary);

        return query.getResultList();
    }
}
