package com.dn.springdata.repo;

import com.dn.springdata.model.QA;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by adam on 18.03.2017.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class QARepositoryTest {

    @Autowired
    private QARepository qaRepository;

    @Test
    public void shouldReturnAllQAWithSurnameSampleQA() {
        // given
        QA qa1 = new QA();
        qa1.setFirstName("Name1");
        qa1.setLastName("SampleQA");

        QA qa2 = new QA();
        qa2.setFirstName("Name2");
        qa2.setLastName("SampleQA!");

        QA qa3 = new QA();
        qa3.setFirstName("Name3");
        qa3.setLastName("SampleQA");

        // when
//        int size = qa

        // then
    }

}
