package com.dn.springdata.repo;

import com.dn.springdata.model.Developer;
import com.dn.springdata.model.ExperienceLevelEnum;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Collection;

/**
 * Created by adam on 18.03.2017.
 */
public interface DeveloperRepository extends PagingAndSortingRepository<Developer, Long> {

    Iterable<Developer> findAllSeniorDevelopers();

    Iterable<Developer> findByExperienceLevel(ExperienceLevelEnum experienceLevel);

    Double findAverageSalaryForExperienceLevel(ExperienceLevelEnum experienceLevel);

    Collection<Developer> findByFirstName(String firstName);

}
