package com.snoopgame.application.controllers;

import com.snoopgame.application.Entities.Employee;
import com.snoopgame.application.Entities.Order;
import com.snoopgame.application.Entities.Phone;
import com.snoopgame.application.Entities.Status;
import com.snoopgame.application.Repositories.OrderRepository;
import com.snoopgame.application.objectsForJSON.Orders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;

@RestController
public class OrderController {
    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/order")
    public Orders sendOrders() {
      /*  orderRepository.save(new Order(
                new Date(1000L),new Date(100L),
                new Employee("sadas","wqeq","ewr[ep"),
                new Phone("samsung",2,2,"android 6.0"), Collections.singleton(Status.INITIATED)));*/
        Iterable<Order> orders = orderRepository.findAll();
        return  new Orders(orders);

    }
    @PostMapping("/order/add")
    public String sendCommitA(@RequestBody Order order){
        if(order.getPhone().getId()==5&&order.getEmployee().getId()==10&&order.getId()==1) {
            return "All is working";
        }
        else return "something wrong";
    }
    @PostMapping("/order/update")
    public String sendCommitU(@RequestBody Order order){
        if(order.getId()==1) return "All is working";
        else return "something wrong";
    }
}
