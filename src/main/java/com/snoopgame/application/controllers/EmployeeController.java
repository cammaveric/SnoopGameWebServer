package com.snoopgame.application.controllers;

import com.snoopgame.application.Entities.Employee;
import com.snoopgame.application.Entities.Order;
import com.snoopgame.application.Entities.Status;
import com.snoopgame.application.Repositories.EmployeeRepository;
import com.snoopgame.application.Repositories.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
@RequestMapping("/employee")
@Controller
public class EmployeeController {
    private final EmployeeRepository employeeRepository;
    private final OrderRepository orderRepository;

    public EmployeeController(EmployeeRepository employeeRepository, OrderRepository orderRepository) {
        this.employeeRepository = employeeRepository;
        this.orderRepository = orderRepository;
    }

    @PostMapping("/add")
    public String addEmployee(Employee employee, Map<String, Object> model) {
        Employee employeeFromDb = employeeRepository.findByNameAndSurnameAndMiddleName(employee.getName(),
                employee.getSurname(), employee.getMiddleName());
        if (employeeFromDb != null) {
            model.put("message", "Employee already exists!");
            return "error";
        }
        employeeRepository.save(employee);
        return "redirect:/main";
    }

    @PostMapping("/remove")
    public String removeEmployee(Employee employee, Map<String, Object> model) {
        Employee employeeFromDb = employeeRepository.findByNameAndSurnameAndMiddleName(employee.getName(),
                employee.getSurname(), employee.getMiddleName());
        if (employeeFromDb == null) {
            model.put("message", "Employee not exists!");
            return "error";
        }
        ArrayList<Order> orders = (ArrayList<Order>) orderRepository.findByEmployeeAndStatuses(employeeFromDb,
                Collections.singleton(Status.INITIATED));
        if (orders.size() != 0) {
            model.put("message", "Employee don't returned all phones!");
            return "error";
        }
        orderRepository.deleteAll(orderRepository.findByEmployee(employeeFromDb));
        employeeRepository.delete(employeeFromDb);
        return "redirect:/main";
    }

}
