package com.snoopgame.application.controllers;

import com.snoopgame.application.Entities.Order;
import com.snoopgame.application.Entities.Status;
import com.snoopgame.application.Repositories.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/order")
public class OrderController {
    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public String getOrders(Model model) {
        model.addAttribute("orders", orderRepository.findAllOrderByIdDesc());
        return "order";
    }

    @GetMapping("/remove/{order}")
    public String deleteOrder(@PathVariable Order order, Model model) {
        Optional<Order> orderFromDb = orderRepository.findById(order.getId());
        if (orderFromDb.get().getStatus() == Status.INITIATED) {
            model.addAttribute("message", "Order not executed!");
            return "error";
        }
        orderRepository.delete(order);
        return "redirect:/order";
    }
}
