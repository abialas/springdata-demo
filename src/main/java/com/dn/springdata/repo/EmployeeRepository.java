package com.dn.springdata.repo;

import com.dn.springdata.model.Employee;
import com.dn.springdata.model.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by adam on 18.03.2017.
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    List<Employee> findByFirstName(String firstName);

    @Query("Select e from Employee e where e.lastName = :lastName")
    List<Employee> findByLastName(@Param("lastName") String lastName);

    List<Employee> findByLastNameAndFirstName(String lastName, String firstName);

    List<Employee> findByAddressCity(String city);

}
