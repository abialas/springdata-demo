package com.dn.springdata.repo.jpa;

import com.dn.springdata.model.DocHeader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by adam on 25.03.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class DocHeaderJpaRepositoryTest {

    @Autowired
    private DocHeaderJpaRepository docHeaderRepository;

    @Test
    public void shouldSaveNewDocHeader() {
        // given
        DocHeader docHeader = new DocHeader();
        docHeader.setDocNumber("01/03/2017");

        // when
        DocHeader savedDocHeader = docHeaderRepository.save(docHeader);

        // then
        assertThat(savedDocHeader.getId(), notNullValue());
    }

    @Test
    public void shouldGetEmptyIterableOfDocHeaders() {
        // when
        Iterable<DocHeader> docHeaderIterable = docHeaderRepository.findAll();

        // then
        assertThat(docHeaderIterable.spliterator().getExactSizeIfKnown(), is(0l));
    }

}
