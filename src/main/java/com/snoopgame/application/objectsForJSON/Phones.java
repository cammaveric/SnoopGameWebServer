package com.snoopgame.application.objectsForJSON;

import com.snoopgame.application.Entities.Phone;

import java.util.ArrayList;

public class Phones {
    Iterable<Phone> phones;
    public Phones(Iterable<Phone> phones) {
        this.phones = phones;
    }

    public Iterable<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Iterable<Phone> phones) {
        this.phones = phones;
    }

}

