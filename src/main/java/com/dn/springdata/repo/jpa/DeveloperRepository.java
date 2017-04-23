package com.dn.springdata.repo.jpa;

import com.dn.springdata.model.Developer;
import com.dn.springdata.model.DeveloperContactInfo;
import com.dn.springdata.model.ExperienceLevelEnum;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.Collection;
import java.util.List;

/**
 * Created by adam on 18.03.2017.
 */
public interface DeveloperRepository extends PagingAndSortingRepository<Developer, Long>, CustomDeveloperRepository, QueryByExampleExecutor<Developer>, QueryDslPredicateExecutor<Developer> {

    Iterable<Developer> findAllSeniorDevelopers();

    List<Developer> findAllSeniorDevelopers(Sort sort);

    Iterable<Developer> findByExperienceLevel(ExperienceLevelEnum experienceLevel);

    Double findAverageSalaryForExperienceLevel(ExperienceLevelEnum experienceLevel);

    Collection<Developer> findByFirstName(String firstName);

    @Query("select min(d.salary) from Developer d where d.experienceLevel = ?1")
    Double findSalaryForDevsWithExperienceLevel(ExperienceLevelEnum experienceLevel);

    List<DeveloperContactInfo> findByAddressCity(String city);

    @Modifying
    @Query("update Developer d set d.experienceLevel = :newExperienceLevel where d.experienceLevel = :oldExperienceLevel")
    int updateExperienceLevelForDevsWithGivenExperience(
            @Param("oldExperienceLevel") ExperienceLevelEnum oldExperienceLevel,
            @Param("newExperienceLevel") ExperienceLevelEnum newExperienceLevel);

}
