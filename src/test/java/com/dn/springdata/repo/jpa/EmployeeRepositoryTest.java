package com.dn.springdata.repo.jpa;

import com.dn.springdata.model.Address;
import com.dn.springdata.model.Employee;
import com.dn.springdata.model.EmployeePosition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Created by adam on 18.03.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void shouldReturnEmptyIterableWhenNoEmployees() {
        assertThat(employeeRepository.findAll().iterator().hasNext(), is(false));
    }

    @Test
    public void shouldReturnFindAllSizeOneAfterAddOneEmployee() {
        Employee employee = new Employee(EmployeePosition.DEVELOPER);
        employee.setFirstName("Adam");
        employee.setLastName("Bialas");
        employee.setStartDate(LocalDate.of(2015, 1, 1));

        employeeRepository.save(employee);
        assertThat(employeeRepository.findAll().spliterator().getExactSizeIfKnown(), is(1l));
    }

    @Test
    public void shouldFindOneEmployeeByFirstNamePawel() {
        Employee employee = new Employee(EmployeePosition.DEVELOPER);
        employee.setFirstName("Pawel");
        employee.setLastName("XXX");
        employee.setStartDate(LocalDate.of(2015, 1, 1));

        employeeRepository.save(employee);

        assertThat(employeeRepository.findByFirstName("Pawel").size(), equalTo(1));
    }

    @Test
    public void shouldFindOneEmployeeByLastNameBialas() {
        Employee employee = new Employee(EmployeePosition.DEVELOPER);
        employee.setFirstName("Adam");
        employee.setLastName("Bialas");
        employee.setStartDate(LocalDate.of(2015, 1, 1));

        employeeRepository.save(employee);

        assertThat(employeeRepository.findByLastName("Bialas").size(), equalTo(1));
    }

    @Test
    public void shouldFindOneByCityKatowice() {
        Employee employee = new Employee(EmployeePosition.DEVELOPER);
        employee.setFirstName("Adam");
        employee.setLastName("Bialas");
        employee.setStartDate(LocalDate.of(2015, 1, 1));

        Address address = new Address();
        address.setCity("Katowice");
        address.setStreet("Gawronow");

        employee.setAddress(address);

        employeeRepository.save(employee);

        assertThat(employeeRepository.findByAddressCity("Katowice").size(), equalTo(1));
    }

}
