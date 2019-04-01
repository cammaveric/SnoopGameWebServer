package com.snoopgame.application.api.controllers;

import com.snoopgame.application.Entities.Order;
import com.snoopgame.application.Entities.Phone;
import com.snoopgame.application.Entities.Status;
import com.snoopgame.application.Repositories.EmployeeRepository;
import com.snoopgame.application.Repositories.OrderRepository;
import com.snoopgame.application.Repositories.PhoneRepository;
import com.snoopgame.application.objectsForJSON.Orders;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;

@RequestMapping("/api/order")
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

    @GetMapping("/getAll")
    public Orders sendAllOrders() {
        Iterable<Order> orders = orderRepository.findByStatus(Status.INITIATED);
        return new Orders(orders, null, null);

    }

    @GetMapping("/getByFirmware")
    public Orders sendOrders() {
        Iterable<Order> androidOrders = orderRepository.findByPhoneInAndStatus(
                phoneRepository.findByFirmware_name("Android"), Status.INITIATED);
        Iterable<Order> iOSOrders = orderRepository.findByPhoneInAndStatus(
                phoneRepository.findByFirmware_name("iOS"), Status.INITIATED);
        Iterable<Order> amazonOrders = orderRepository.findByPhoneInAndStatus(
                phoneRepository.findByFirmware_name("Amazon"), Status.INITIATED);
        return new Orders(androidOrders, iOSOrders, amazonOrders);

    }

    @PostMapping("/add")
    public void addOrder(@RequestBody Order order) {
        Phone phone = phoneRepository.findByNameAndFirmware_nameAndFirmware_version(
                order.getPhone().getName(), order.getPhone().getFirmware_name(),
                order.getPhone().getFirmware_version());
        orderRepository.save(new Order(
                new Date(System.currentTimeMillis()).toString() + " " + new Time(System.currentTimeMillis()).toString(),
                employeeRepository.findByNameAndSurnameAndMiddleName(
                        order.getEmployee().getName(), order.getEmployee().getSurname(),
                        order.getEmployee().getMiddleName()),
                phone, Status.INITIATED));
        phone.setFree_phone_amount(phone.getFree_phone_amount() - 1);
        phoneRepository.save(phone);

    }

    @PostMapping("/update")
    public void updateOrder(@RequestBody Order order) {
        Phone phone = phoneRepository.findByNameAndFirmware_nameAndFirmware_version(
                order.getPhone().getName(), order.getPhone().getFirmware_name(),
                order.getPhone().getFirmware_version());
        Order orderFromDb = orderRepository.findByEmployeeAndPhoneAndDate_start(
                employeeRepository.findByNameAndSurnameAndMiddleName(
                        order.getEmployee().getName(), order.getEmployee().getSurname(),
                        order.getEmployee().getMiddleName()), phone, order.getDate_start());
        orderFromDb.setStatus(Status.EXECUTED);
        orderFromDb.setDate_end(new Date(System.currentTimeMillis()).toString() + " " + new Time(System.currentTimeMillis()).toString());
        phone.setFree_phone_amount(phone.getFree_phone_amount() + 1);
        orderRepository.save(orderFromDb);
        phoneRepository.save(phone);
    }
}
