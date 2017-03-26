package com.dn.springdata.repo;

import com.dn.springdata.model.QA;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


/**
 * Created by adam on 18.03.2017.
 */
@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest
public class QARepositoryTest {

    @Autowired
    private QARepository qaRepository;

    @Test
    @Sql("/data/qa.sql")
    public void shouldReturnAllQAWithSurnameSampleQA() {
        // when
        Iterable<QA> seniorQAs = qaRepository.findAllByLastName("SampleQA");

        // then
        assertThat(seniorQAs.spliterator().getExactSizeIfKnown(), is(2l));
    }

}
