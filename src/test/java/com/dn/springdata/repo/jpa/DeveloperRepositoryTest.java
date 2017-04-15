package com.dn.springdata.repo.jpa;

import com.dn.springdata.model.Developer;
import com.dn.springdata.model.DeveloperContactInfo;
import com.dn.springdata.model.ExperienceLevelEnum;
import com.dn.springdata.model.ProgrammingLanguage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by adam on 19.03.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@Sql("/data/developers.sql")
public class DeveloperRepositoryTest {

    @Autowired
    private DeveloperRepository developerRepository;

    @Test
    public void shouldListAllDevelopers() {
        // when
        Iterable<Developer> employees = developerRepository.findAll();

        // then
        assertThat(employees.spliterator().getExactSizeIfKnown(), is(5l));
    }

    @Test
    public void shouldAddNewDeveloper() {
        // given
        Developer developer = new Developer();
        developer.setFirstName("Adam");
        developer.setLastName("Bialas");
        developer.setExperienceLevel(ExperienceLevelEnum.SENIOR);
        developer.setUser("abialas");
        developer.setProgrammingLanguages(Arrays.asList(ProgrammingLanguage.JAVA, ProgrammingLanguage.C_SHARP));

        // when
        developerRepository.save(developer);
        Iterable<Developer> developers = developerRepository.findAll();

        // then
        assertThat(developers.iterator().hasNext(), is(true));
        assertThat(developers.spliterator().getExactSizeIfKnown(), is(6l));
    }

    @Test
    public void shouldListAllSeniorDevelopers() {
        // when
        Iterable<Developer> seniorDevelopers = developerRepository.findAllSeniorDevelopers();

        // then
        assertThat(seniorDevelopers.spliterator().getExactSizeIfKnown(), is(2l));
    }

    @Test
    public void shouldListOnlySeniorDevelopers() {
        // when
        Iterable<Developer> seniorDevelopers = developerRepository.findByExperienceLevel(ExperienceLevelEnum.SENIOR);

        // then
        assertThat(seniorDevelopers.spliterator().getExactSizeIfKnown(), is(2l));
    }

    @Test
    public void shouldListOnlyProfessionalDevelopers() {
        // when
        Iterable<Developer> proDevelopers = developerRepository.findByExperienceLevel(ExperienceLevelEnum.PROFESSIONAL);

        // then
        assertThat(proDevelopers.spliterator().getExactSizeIfKnown(), is(2l));
    }

    @Test
    public void shouldListOnlyJuniorDevelopers() {
        // when
        Iterable<Developer> juniorDevelopers = developerRepository.findByExperienceLevel(ExperienceLevelEnum.JUNIOR);

        // then
        assertThat(juniorDevelopers.spliterator().getExactSizeIfKnown(), is(1l));
    }

    @Test
    public void shouldReturnAverageSalaryForSeniorDevelopers() {
        // when
        Double averageSalary = developerRepository.findAverageSalaryForExperienceLevel(ExperienceLevelEnum.SENIOR);

        // then
        assertThat(averageSalary, is(1000.0));
    }

    @Test
    public void shouldReturnTwoDevelopersWithFirstNameAdam() {
        // when
        Collection<Developer> developers = developerRepository.findByFirstName("Adam");

        // then
        assertThat(developers.size(), is(2));
    }

    @Test
    @Sql("/data/junior_developers.sql")
    public void shouldOverrideClassSQLAnnotationAndReturnThreeDevelopers() {
        // when
        Iterable<Developer> developers = developerRepository.findAll();

        // then
        assertThat(developers.spliterator().getExactSizeIfKnown(), is(3l));
    }

    @Test
    public void shouldExecuteMethodFromQueryAnnotation() {
        // when
        Double minSalary = developerRepository.findSalaryForDevsWithExperienceLevel(ExperienceLevelEnum.SENIOR);

        // then
        assertThat(minSalary, is(500.0));
    }

    @Test
    public void shouldReturnAdamAsMostPopularFirstName() {
        // when
        String mostPopularName = developerRepository.findMostPopularFirstName();

        // then
        assertThat(mostPopularName, is("Adam"));
    }

    @Test
    @Transactional
    public void shouldUpdateTwoProfessionalDevelopersToSenior() {
        // when
        int devsUpdatedCount = developerRepository.updateExperienceLevelForDevsWithGivenExperience(
                ExperienceLevelEnum.PROFESSIONAL,
                ExperienceLevelEnum.SENIOR);

        // then
        assertThat(devsUpdatedCount, is(2));
    }

    @Test
    public void shouldReturnDevelopersContactInfo() {
        // when
        List<DeveloperContactInfo> developerContactInfos = developerRepository.findByAddressCity("Krakow");

        // then
        assertThat(developerContactInfos.size(), is(3));
        assertThat(developerContactInfos.get(0).getCity(), is("Krakow"));
        assertThat(developerContactInfos.get(1).getCity(), is("Krakow"));
        assertThat(developerContactInfos.get(2).getCity(), is("Krakow"));
    }

}
