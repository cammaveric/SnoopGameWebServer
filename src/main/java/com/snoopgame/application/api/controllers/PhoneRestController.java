package com.snoopgame.application.api.controllers;

import com.snoopgame.application.Entities.Phone;
import com.snoopgame.application.Repositories.PhoneRepository;
import com.snoopgame.application.objectsForJSON.Phones;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/phone")
@RestController
public class PhoneRestController {
    private final PhoneRepository phoneRepository;

    public PhoneRestController(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    @GetMapping("/getAll")
    public Phones sendAllPhones() {
        Iterable<Phone> phones = phoneRepository.findByFree_phone_amountGreaterThan(0);
        return new Phones(phones, null, null);
    }

    @GetMapping("/getByFirmware")
    public Phones sendPhones() {
        Iterable<Phone> androidPhones = phoneRepository
                .findByFirmware_nameAndFree_phone_amountGreaterThan("Android", 0);
        Iterable<Phone> iOSPhones = phoneRepository
                .findByFirmware_nameAndFree_phone_amountGreaterThan("iOS", 0);
        Iterable<Phone> amazonPhones = phoneRepository
                .findByFirmware_nameAndFree_phone_amountGreaterThan("Amazon", 0);
        return new Phones(androidPhones, iOSPhones, amazonPhones);
    }
}
