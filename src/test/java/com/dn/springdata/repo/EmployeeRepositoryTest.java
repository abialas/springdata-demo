package com.dn.springdata.repo;

import com.dn.springdata.model.Employee;
import com.dn.springdata.model.EmployeePosition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by adam on 18.03.2017.
 */
@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void shouldReturnEmptyIterableWhenNoEmployees() {
        assertThat(employeeRepository.findAll().iterator().hasNext(), is(false));
    }

    @Test
    public void shouldReturnNotEmptyFindAllAfterAddOneEmployee() {
        Employee employee = new Employee(EmployeePosition.DEVELOPER);
        employee.setFirstName("Adam");
        employee.setLastName("Bialas");
        employee.setStartDate(LocalDate.of(2015, 1, 1));

        employeeRepository.save(employee);
        assertThat(employeeRepository.findAll().iterator().hasNext(), is(true));
        assertThat(employeeRepository.findAll().iterator().next().getPosition(), is(EmployeePosition.DEVELOPER));
    }



}
