package com.snoopgame.application.controllers;

import com.snoopgame.application.Entities.Order;
import com.snoopgame.application.Entities.Status;
import com.snoopgame.application.Repositories.EmployeeRepository;
import com.snoopgame.application.Repositories.OrderRepository;
import com.snoopgame.application.Repositories.PhoneRepository;
import com.snoopgame.application.objectsForJSON.Orders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.sql.Date;
import java.util.*;

@RestController
public class OrderController {
    private final OrderRepository orderRepository;
    private final EmployeeRepository employeeRepository;
    private final PhoneRepository phoneRepository;

    public OrderController(OrderRepository orderRepository, EmployeeRepository employeeRepository, PhoneRepository phoneRepository) {
        this.orderRepository = orderRepository;
        this.employeeRepository = employeeRepository;
        this.phoneRepository = phoneRepository;
    }

    @GetMapping("/order")
    public Orders sendOrders() {
        Iterable<Order> orders = orderRepository.findByStatuses(Collections.singleton(Status.INITIATED));
        return  new Orders(orders);

    }
    @PostMapping("/order/add")
    public void addOrder(@RequestBody Order order){

        orderRepository.save(new Order(
                new Date(System.currentTimeMillis()),
                null,
                employeeRepository.findById(order.getEmployee().getId()).get(),
                phoneRepository.findById(order.getPhone().getId()).get(),
                Collections.singleton(Status.INITIATED)));

    }
    @PostMapping("/order/update")
    public void updateOrder(@RequestBody Order order){
        Optional<Order> orderDB = orderRepository.findById(order.getId());
        orderDB.get().getStatuses().removeAll(Collections.singleton(Status.INITIATED));
        orderDB.get().getStatuses().addAll(Collections.singleton(Status.EXECUTED));
        orderDB.get().setDate_end(new Date(System.currentTimeMillis()));
        orderRepository.save(orderDB.get());
    }
}
