package com.dn.springdata.repo;

import com.dn.springdata.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by adam on 20.03.2017.
 */
public interface TaskReposiory extends JpaRepository<Task, Long> {

    @Query("select t from Task t where t.name = :taskName")
    List<Task> findTasksByName(@Param("taskName") String taskName);

}
