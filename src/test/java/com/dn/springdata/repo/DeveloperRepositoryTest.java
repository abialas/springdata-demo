package com.dn.springdata.repo;

import com.dn.springdata.model.Developer;
import com.dn.springdata.model.Employee;
import com.dn.springdata.model.ExperienceLevelEnum;
import com.dn.springdata.model.ProgrammingLanguage;
import org.h2.tools.Server;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Created by adam on 19.03.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class DeveloperRepositoryTest {

    @Autowired
    private DeveloperRepository developerRepository;

    @BeforeClass
    public static void setUpServer() throws SQLException {
        Server webServer = Server.createWebServer("-web", "-webAllowOthers", "-webPort" ,"8082").start();
        Server server = Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092").start();
    }

    @Test
    @Sql("/data/developers.sql")
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
        developer.setProgrammingLanguages(Arrays.asList(ProgrammingLanguage.JAVA, ProgrammingLanguage.C_SHARP));

        // when
        developerRepository.save(developer);
        Iterable<Developer> developers = developerRepository.findAll();

        // then
        assertThat(developers.iterator().hasNext(), is(true));
        assertThat(developers.spliterator().getExactSizeIfKnown(), is(1l));
    }

    @Test
    @Sql("/data/developers.sql")
    public void shouldListAllSeniorDevelopers() {
        // when
        Iterable<Developer> seniorDevelopers = developerRepository.findAllSeniorDevelopers();

        // then
        assertThat(seniorDevelopers.spliterator().getExactSizeIfKnown(), equalTo(2l));
    }

    @Test
    @Sql("/data/developers.sql")
    public void shouldListOnlySeniorDevelopers() {
        // when
        Iterable<Developer> seniorDevelopers = developerRepository.findByExperienceLevel(ExperienceLevelEnum.SENIOR);

        // then
        assertThat(seniorDevelopers.spliterator().getExactSizeIfKnown(), equalTo(2l));
    }

    @Test
    @Sql("/data/developers.sql")
    public void shouldListOnlyProfessionalDevelopers() {
        // when
        Iterable<Developer> proDevelopers = developerRepository.findByExperienceLevel(ExperienceLevelEnum.PROFESSIONAL);

        // then
        assertThat(proDevelopers.spliterator().getExactSizeIfKnown(), equalTo(2l));
    }

    @Test
    @Sql("/data/developers.sql")
    public void shouldListOnlyJuniorDevelopers() {
        // when
        Iterable<Developer> juniorDevelopers = developerRepository.findByExperienceLevel(ExperienceLevelEnum.JUNIOR);

        // then
        assertThat(juniorDevelopers.spliterator().getExactSizeIfKnown(), equalTo(1l));
    }

}
