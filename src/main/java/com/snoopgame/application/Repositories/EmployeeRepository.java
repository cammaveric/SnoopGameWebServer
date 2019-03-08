package com.snoopgame.application.Repositories;

import com.snoopgame.application.Entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    Employee findByNameAndSurnameAndMiddleName(String name, String surname, String middleName);
    @Query("select e from Employee e order by e.surname asc")
    Iterable<Employee> findAllOrderBySurnameAsc();
}
