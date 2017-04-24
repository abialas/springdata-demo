package com.dn.springdata.repo.jpa;

import com.dn.springdata.model.Developer;

import java.util.List;

/**
 * Created by adam on 04.04.2017.
 */
public interface CustomDeveloperRepository {

    String findMostPopularFirstName();

    List<Developer> findDevelopersWithSalaryBiggerThanCriteriaQuery(double salary);

    List<Developer> findDevelopersWithSalaryBiggerThanCriteriaQueryWithMetaModel(double salary);

    List<Developer> findDevelopersWithSalaryBiggerThanJPQL(double salary);

}
