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
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Collections;

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
        return new Orders(orders, null, null);

    }

    @GetMapping("/order/getByFirmware")
    public Orders sendOrders() {
        Iterable<Order> androidOrders = orderRepository.findByPhoneInAndStatuses(
                phoneRepository.findByFirmware_name("Android"),
                Collections.singleton(Status.INITIATED));
        Iterable<Order> iOSOrders = orderRepository.findByPhoneInAndStatuses(
                phoneRepository.findByFirmware_name("iOS"),
                Collections.singleton(Status.INITIATED));
        Iterable<Order> amazonOrders = orderRepository.findByPhoneInAndStatuses(
                phoneRepository.findByFirmware_name("Amazon"),
                Collections.singleton(Status.INITIATED));
        return new Orders(androidOrders, iOSOrders, amazonOrders);

    }

    @PostMapping("/order/add")
    public void addOrder(@RequestBody Order order) {
        Phone phone = phoneRepository.findByNameAndFirmware_nameAndFirmware_version(
                order.getPhone().getName(), order.getPhone().getFirmware_name(),
                order.getPhone().getFirmware_version());
        orderRepository.save(new Order(
                new Date(System.currentTimeMillis()).toString() + " " + new Time(System.currentTimeMillis()).toString(), null,
                employeeRepository.findByNameAndSurnameAndMiddleName(
                        order.getEmployee().getName(), order.getEmployee().getSurname(),
                        order.getEmployee().getMiddleName()),
                phone, Collections.singleton(Status.INITIATED)));
        phone.setFree_phone_amount(phone.getFree_phone_amount() - 1);
        phoneRepository.save(phone);

    }

    @PostMapping("/order/update")
    public void updateOrder(@RequestBody Order order) {
        Phone phone = phoneRepository.findByNameAndFirmware_nameAndFirmware_version(
                order.getPhone().getName(), order.getPhone().getFirmware_name(),
                order.getPhone().getFirmware_version());
        Order orderFromDb = orderRepository.findByEmployeeAndPhoneAndDate_start(
                employeeRepository.findByNameAndSurnameAndMiddleName(
                        order.getEmployee().getName(), order.getEmployee().getSurname(),
                        order.getEmployee().getMiddleName()), phone, order.getDate_start());
        orderFromDb.getStatuses().removeAll(Collections.singleton(Status.INITIATED));
        orderFromDb.getStatuses().addAll(Collections.singleton(Status.EXECUTED));
        orderFromDb.setDate_end(new Timestamp(System.currentTimeMillis()));
        phone.setFree_phone_amount(phone.getFree_phone_amount() + 1);
        orderRepository.save(orderFromDb);
        phoneRepository.save(phone);
    }
}
