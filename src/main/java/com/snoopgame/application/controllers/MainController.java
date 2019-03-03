package com.snoopgame.application.controllers;

import com.snoopgame.application.Repositories.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {
    private final OrderRepository orderRepository;

    public MainController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public String getOrders(Model model){
        model.addAttribute("orders",orderRepository.findAll());
        return "main";
    }
}
