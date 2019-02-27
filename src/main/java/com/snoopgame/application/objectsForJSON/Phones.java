package com.snoopgame.application.objectsForJSON;

import com.snoopgame.application.Entities.Phone;

import java.util.ArrayList;

public class Phones {
    private Iterable<Phone> androidPhones;
    private Iterable<Phone> iOSPhones;
    private Iterable<Phone> amazonPhones;

    public Iterable<Phone> getAndroidPhones() {
        return androidPhones;
    }

    public void setAndroidPhones(Iterable<Phone> androidPhones) {
        this.androidPhones = androidPhones;
    }

    public Iterable<Phone> getiOSPhones() {
        return iOSPhones;
    }

    public void setiOSPhones(Iterable<Phone> iOSPhones) {
        this.iOSPhones = iOSPhones;
    }

    public Iterable<Phone> getAmazonPhones() {
        return amazonPhones;
    }

    public void setAmazonPhones(Iterable<Phone> amazonPhones) {
        this.amazonPhones = amazonPhones;
    }

    public Phones(Iterable<Phone> androidPhones, Iterable<Phone> iOSPhones, Iterable<Phone> amazonPhones) {
        this.androidPhones = androidPhones;
        this.iOSPhones = iOSPhones;
        this.amazonPhones = amazonPhones;
    }
}

