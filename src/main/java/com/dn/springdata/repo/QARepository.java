package com.dn.springdata.repo;

import com.dn.springdata.model.QA;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by adam on 18.03.2017.
 */
public interface QARepository extends ReadOnlyRepository<QA, Long> {

    List<QA> findAllByLastName(String lastName);

}
