package com.snoopgame.application.Repositories;

import com.snoopgame.application.Entities.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
    Employee findByNameAndSurnameAndMiddleName(String name, String surname, String middleName);
}
