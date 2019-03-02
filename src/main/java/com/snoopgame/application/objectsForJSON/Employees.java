package com.snoopgame.application.objectsForJSON;


import com.snoopgame.application.Entities.Employee;

public class Employees {
    Iterable<Employee> employees;

    public Iterable<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Iterable<Employee> employees) {
        this.employees = employees;
    }

    public Employees() {
    }

    public Employees(Iterable<Employee> employees) {
        this.employees = employees;
    }
}
