package com.snoopgame.application.controllers;

import com.snoopgame.application.Entities.Employee;
import com.snoopgame.application.Entities.Order;
import com.snoopgame.application.Entities.Status;
import com.snoopgame.application.Repositories.EmployeeRepository;
import com.snoopgame.application.Repositories.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

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
    public String addEmployee(Employee employee, Model model) {
        Employee employeeFromDb = employeeRepository.findByNameAndSurnameAndMiddleName(employee.getName(),
                employee.getSurname(), employee.getMiddleName());
        if (employeeFromDb != null) {
            model.addAttribute("message", "Employee already exists!");
            return "error";
        }
        employeeRepository.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("/remove/{employee}")
    public String removeEmployee(@PathVariable Employee employee, Model model) {
        Employee employeeFromDb = employeeRepository.findByNameAndSurnameAndMiddleName(employee.getName(),
                employee.getSurname(), employee.getMiddleName());
        ArrayList<Order> orders = (ArrayList<Order>) orderRepository
                .findByEmployeeAndStatus(employeeFromDb, Status.INITIATED);
        if (orders.size() != 0) {
            model.addAttribute("message", "Employee don't returned all phones!");
            return "error";
        }
        orderRepository.deleteAll(orderRepository.findByEmployee(employeeFromDb));
        employeeRepository.delete(employeeFromDb);
        return "redirect:/employee";
    }

    @GetMapping
    public String getEmployees(Model model) {
        model.addAttribute("employees", employeeRepository.findAllOrderBySurnameAsc());
        return "employee";
    }

}
