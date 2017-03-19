package com.dn.springdata.repo;

import com.dn.springdata.model.Developer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by adam on 18.03.2017.
 */
public interface DeveloperRepository extends PagingAndSortingRepository<Developer, Long> {
}
