package com.dn.springdata.repo;

import com.dn.springdata.model.DocHeader;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by adam on 25.03.2017.
 */
public interface DocHeaderRepository extends CrudRepository<DocHeader, String> {
}