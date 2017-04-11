package com.dn.springdata.repo.jpa;

import com.dn.springdata.model.QA;

import java.util.List;

/**
 * Created by adam on 18.03.2017.
 */
public interface QARepository extends ReadOnlyRepository<QA, Long> {

    List<QA> findAllByLastName(String lastName);

}
