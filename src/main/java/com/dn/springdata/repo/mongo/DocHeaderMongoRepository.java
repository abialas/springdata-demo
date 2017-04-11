package com.dn.springdata.repo.mongo;

import com.dn.springdata.model.DocHeader;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by adam on 25.03.2017.
 */
public interface DocHeaderMongoRepository extends MongoRepository<DocHeader, String> {
}
