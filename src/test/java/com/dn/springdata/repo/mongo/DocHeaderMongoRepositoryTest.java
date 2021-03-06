package com.dn.springdata.repo.mongo;

import com.dn.springdata.model.DocHeader;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by adam on 25.03.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DocHeaderMongoRepositoryTest {

    @Autowired
    private DocHeaderMongoRepository docHeaderRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

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

    @After
    public void clearCollection() {
        mongoTemplate.dropCollection(DocHeader.class);
    }

}
