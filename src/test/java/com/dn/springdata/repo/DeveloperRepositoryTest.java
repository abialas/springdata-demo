package com.dn.springdata.repo;

import com.dn.springdata.model.Developer;
import com.dn.springdata.model.Employee;
import com.dn.springdata.model.ProgrammingLanguage;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by adam on 19.03.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeveloperRepositoryTest {

    @Autowired
    private DeveloperRepository developerRepository;

    @Test
    public void shouldAddNewDeveloper() {
        // given
        Developer developer = new Developer();
        developer.setFirstName("Adam");
        developer.setLastName("Bialas");
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
    public void shouldListAllDevelopers() {
        // when
        Iterable<Developer> employees = developerRepository.findAll();

        // then
        assertThat(employees.spliterator().getExactSizeIfKnown(), is(3l));
    }

    @After
    public void cleanupDB() {
        developerRepository.deleteAll();
    }
}
