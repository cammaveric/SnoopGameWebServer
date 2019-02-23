package com.snoopgame.application.controllers;

import com.snoopgame.application.objectsForJSON.Employee;
import com.snoopgame.application.objectsForJSON.Employees;
import com.snoopgame.application.objectsForJSON.Phone;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class EmployeeController {
    @GetMapping ("/employee/get")
    public Employees sendUsers(){
        Employee employee=new Employee(10,"Kudjo","Joestar","Jotaro");
        ArrayList<Employee>arrayList=new ArrayList<>();
        arrayList.add(employee);
        System.out.println("\n"+"sadas"+"\n");
        return new Employees(arrayList);
    }
}
