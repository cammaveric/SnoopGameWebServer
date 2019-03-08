package com.snoopgame.application.controllers;

import com.snoopgame.application.Entities.Order;
import com.snoopgame.application.Entities.Phone;
import com.snoopgame.application.Entities.Status;
import com.snoopgame.application.Repositories.OrderRepository;
import com.snoopgame.application.Repositories.PhoneRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

@RequestMapping("/phone")
@Controller
public class PhoneController {
    private final PhoneRepository phoneRepository;
    private final OrderRepository orderRepository;

    public PhoneController(PhoneRepository phoneRepository, OrderRepository orderRepository) {
        this.phoneRepository = phoneRepository;
        this.orderRepository = orderRepository;
    }

    @PostMapping("/add")
    public String addPhone(Phone phone, Model model) {
        Phone phoneFromDb = phoneRepository.findByNameAndFirmware_nameAndFirmware_version(phone.getName(),
                phone.getFirmware_name(), phone.getFirmware_version());
        if (phoneFromDb != null) {
            model.addAttribute("message", "Phone already exists! The number of phones has been increased by " + phone.getAmount());
            phoneFromDb.setAmount(phoneFromDb.getAmount() + phone.getAmount());
            phoneFromDb.setFree_phone_amount(phoneFromDb.getFree_phone_amount() + phone.getFree_phone_amount());
            phoneRepository.save(phoneFromDb);
            return "error";
        }
        phone.setFree_phone_amount(phone.getAmount());
        phoneRepository.save(phone);
        return "redirect:/phone";
    }

    @GetMapping("/remove/{phone}")
    public String removePhone(@PathVariable Phone phone, Model model) {
        Phone phoneFromDb = phoneRepository.findByNameAndFirmware_nameAndFirmware_version(phone.getName(),
                phone.getFirmware_name(), phone.getFirmware_version());
        if (phone.getAmount() == phoneFromDb.getAmount()) {
            ArrayList<Order> orders = (ArrayList<Order>) orderRepository.findByPhoneAndStatuses(phoneFromDb,
                    Collections.singleton(Status.INITIATED));
            if (orders.size() != 0) {
                model.addAttribute("message", "Not executed orders contains this phone!");
                return "error";
            }
            orderRepository.deleteAll(orderRepository.findByPhone(phoneFromDb));
            phoneRepository.delete(phoneFromDb);
        }
        phoneFromDb.setAmount(phoneFromDb.getAmount() - phone.getAmount());
        phoneFromDb.setFree_phone_amount(phoneFromDb.getFree_phone_amount() - phone.getFree_phone_amount());
        phoneRepository.save(phoneFromDb);
        return "redirect:/phone";
    }
    @GetMapping
    public String getPhones(Model model){
        model.addAttribute("phones",phoneRepository.findAllOrderByFirmware_nameAsc());
        return "phone";
    }
}
