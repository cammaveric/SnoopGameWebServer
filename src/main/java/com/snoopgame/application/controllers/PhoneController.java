package com.snoopgame.application.controllers;

import com.snoopgame.application.objectsForJSON.Phone;
import com.snoopgame.application.objectsForJSON.Phones;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class PhoneController {
    @GetMapping("/phone")
    public Phones sendPhones(){
        Phone phone = new Phone(5, "iPhone 10 XXXL", "iOS 12", 1);
        ArrayList<Phone>arrayList=new ArrayList<>();
        arrayList.add(phone);
        return new Phones(arrayList);
    }
}
