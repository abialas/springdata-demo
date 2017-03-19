package com.dn.springdata.repo;

import com.dn.springdata.model.Developer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by adam on 18.03.2017.
 */
public interface DeveloperRepository extends CrudRepository<Developer, Long> {
}
