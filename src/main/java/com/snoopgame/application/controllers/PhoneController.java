package com.snoopgame.application.controllers;

import com.snoopgame.application.Entities.Phone;
import com.snoopgame.application.Repositories.PhoneRepository;
import com.snoopgame.application.objectsForJSON.Phones;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class PhoneController {
    private final PhoneRepository phoneRepository;

    public PhoneController(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    @GetMapping("/phone/get")
    public Phones sendPhones(){
        Iterable<Phone> phones = phoneRepository.findAll();
        return new Phones(phones);
    }
}
