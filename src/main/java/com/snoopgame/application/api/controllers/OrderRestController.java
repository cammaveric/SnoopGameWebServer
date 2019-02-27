package com.snoopgame.application.api.controllers;

import com.snoopgame.application.Entities.Order;
import com.snoopgame.application.Entities.Phone;
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
import java.util.Collections;
import java.util.Optional;

@RestController
public class OrderRestController {
    private final OrderRepository orderRepository;
    private final EmployeeRepository employeeRepository;
    private final PhoneRepository phoneRepository;

    public OrderRestController(OrderRepository orderRepository, EmployeeRepository employeeRepository, PhoneRepository phoneRepository) {
        this.orderRepository = orderRepository;
        this.employeeRepository = employeeRepository;
        this.phoneRepository = phoneRepository;
    }

    @GetMapping("/order/getAll")
    public Orders sendAllOrders() {
        Iterable<Order> orders = orderRepository.findByStatuses(Collections.singleton(Status.INITIATED));
        return  new Orders(orders,null,null);

    }
    @GetMapping("/order/getByFirmware")
    public Orders sendOrders() {
        Iterable<Order> androidOrders = orderRepository.findByPhoneInAndStatuses(
                phoneRepository.findByFirmware_name("Android"),
                Collections.singleton(Status.INITIATED));
        Iterable<Order> iOSOrders=orderRepository.findByPhoneInAndStatuses(
                phoneRepository.findByFirmware_name("iOS"),
                Collections.singleton(Status.INITIATED));
        Iterable<Order> amazonOrders=orderRepository.findByPhoneInAndStatuses(
                phoneRepository.findByFirmware_name("Amazon"),
                Collections.singleton(Status.INITIATED));
        return  new Orders(androidOrders,iOSOrders,amazonOrders);

    }
    @PostMapping("/order/add")
    public void addOrder(@RequestBody Order order){
        Phone phone=phoneRepository.findById(order.getPhone().getId()).get();
        orderRepository.save(new Order(
                new Date(System.currentTimeMillis()),null,
                employeeRepository.findById(order.getEmployee().getId()).get(),
                phone, Collections.singleton(Status.INITIATED)));
        phone.setFree_phone_amount(phone.getFree_phone_amount()-1);
        phoneRepository.save(phone);

    }
    @PostMapping("/order/update")
    public void updateOrder(@RequestBody Order order){
        Optional<Order> orderFromDb = orderRepository.findById(order.getId());
        orderFromDb.get().getStatuses().removeAll(Collections.singleton(Status.INITIATED));
        orderFromDb.get().getStatuses().addAll(Collections.singleton(Status.EXECUTED));
        orderFromDb.get().setDate_end(new Date(System.currentTimeMillis()));
        Optional<Phone>phone = phoneRepository.findById(orderFromDb.get().getPhone().getId());
        phone.get().setFree_phone_amount(phone.get().getFree_phone_amount()+1);
        orderRepository.save(orderFromDb.get());
        phoneRepository.save(phone.get());
    }
}
