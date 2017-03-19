package com.dn.springdata.repo;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by adam on 19.03.2017.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class DeveloperRepositoryTest {



    @Autowired
    private DeveloperRepository developerRepository;
}
