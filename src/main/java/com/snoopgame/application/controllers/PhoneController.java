package com.snoopgame.application.controllers;

import com.snoopgame.application.Entities.Order;
import com.snoopgame.application.Entities.Phone;
import com.snoopgame.application.Entities.Status;
import com.snoopgame.application.Repositories.OrderRepository;
import com.snoopgame.application.Repositories.PhoneRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

@Controller
public class PhoneController {
    private final PhoneRepository phoneRepository;
    private final OrderRepository orderRepository;

    public PhoneController(PhoneRepository phoneRepository, OrderRepository orderRepository) {
        this.phoneRepository = phoneRepository;
        this.orderRepository = orderRepository;
    }

    @PostMapping("phone/add")
    public String addPhone(Phone phone, Map<String, Object> model) {
        Phone phoneFromDb = phoneRepository.findByNameAndFirmware_nameAndFirmware_version(phone.getName(),
                phone.getFirmware_name(), phone.getFirmware_version());
        if (phoneFromDb != null) {
            model.put("message", "Phone already exists! The number of phones has been increased by " + phone.getAmount());
            phoneFromDb.setAmount(phoneFromDb.getAmount() + phone.getAmount());
            phoneFromDb.setFree_phone_amount(phoneFromDb.getFree_phone_amount() + phone.getFree_phone_amount());
            phoneRepository.save(phoneFromDb);
            return "phone/add";
        }
        phone.setFree_phone_amount(phone.getAmount());
        phoneRepository.save(phone);
        return "redirect:/main";
    }

    @PostMapping("phone/remove")
    public String removePhone(Phone phone, Map<String, Object> model) {
        Phone phoneFromDb = phoneRepository.findByNameAndFirmware_nameAndFirmware_version(phone.getName(),
                phone.getFirmware_name(), phone.getFirmware_version());
        if (phoneFromDb == null) {
            model.put("message", "Phone not exists!");
            return "phone/remove";
        }
        if (phone.getAmount() == phoneFromDb.getAmount()) {
            ArrayList<Order> orders = (ArrayList<Order>) orderRepository.findByPhoneAndStatuses(phoneFromDb,
                    Collections.singleton(Status.INITIATED));
            if (orders.size() != 0) {
                model.put("message", "Not executed orders contains this phone!");
                return "phone/remove";
            }
            orderRepository.deleteAll(orderRepository.findByPhone(phoneFromDb));
            phoneRepository.delete(phoneFromDb);
        }
        phoneFromDb.setAmount(phoneFromDb.getAmount() - phone.getAmount());
        phoneFromDb.setFree_phone_amount(phoneFromDb.getFree_phone_amount() - phone.getFree_phone_amount());
        phoneRepository.save(phoneFromDb);
        return "redirect:/main";

    }
}
