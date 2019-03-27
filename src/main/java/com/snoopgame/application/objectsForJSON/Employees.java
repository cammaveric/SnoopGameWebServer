package com.snoopgame.application.objectsForJSON;


import com.snoopgame.application.Entities.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employees {
    Iterable<Employee> employees;
}
