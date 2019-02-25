package com.snoopgame.application.api.controllers;

import com.snoopgame.application.Entities.Phone;
import com.snoopgame.application.Repositories.PhoneRepository;
import com.snoopgame.application.objectsForJSON.Phones;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhoneRestController {
    private final PhoneRepository phoneRepository;

    public PhoneRestController(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    @GetMapping("/phone/get")
    public Phones sendPhones(){
       Iterable<Phone> phones = phoneRepository.findByFree_phone_amountGreaterThan(0);
        return new Phones(phones);
    }
}
