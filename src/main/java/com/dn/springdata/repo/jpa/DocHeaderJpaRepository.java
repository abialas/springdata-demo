package com.dn.springdata.repo.jpa;

import com.dn.springdata.model.DocHeader;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by adam on 05.04.2017.
 */
public interface DocHeaderJpaRepository extends JpaRepository<DocHeader, String> {
}
