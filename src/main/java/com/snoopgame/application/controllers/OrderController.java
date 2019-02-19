package com.snoopgame.application.controllers;

import com.snoopgame.application.objectsForJSON.Employee;
import com.snoopgame.application.objectsForJSON.Order;
import com.snoopgame.application.objectsForJSON.Orders;
import com.snoopgame.application.objectsForJSON.Phone;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class OrderController {
    @GetMapping("/order")
    public Orders sendOrders() {
        ArrayList<Order> a = new ArrayList<>();
        Employee employee = new Employee(1, "'jora", "asd", "asdsd");
        Phone phone = new Phone(1, "Samsung", "Firmware", 2);
        String date_s = "ну и залупа";
        String date_e = "ebal v rot";
        a.add(new Order(1, employee, phone, date_s, date_e, "executed"));
        Orders orders = new Orders(a);
        return orders;

    }
    @PostMapping("/order/add")
    public String sendCommitA(@RequestBody Order order){
        if(order.getPhone().getId()==5&&order.getEmployee().getId()==10&&order.getId()==1)return "All is working";
        else return "something wrong";
    }
    @PostMapping("/order/update")
    public String sendCommitU(@RequestBody Order order){
        if(order.getId()==1) return "All is working";
        else return "something wrong";
    }
}
