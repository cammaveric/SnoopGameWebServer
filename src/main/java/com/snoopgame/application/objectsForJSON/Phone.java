package com.snoopgame.application.objectsForJSON;


public class Phone {

    private int id;
    private String name;
    private String firmware;
    private int free_phone_amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFree_phone_amount() {
        return free_phone_amount;
    }

    public void setFree_phone_amount(int free_phone_amount) {
        this.free_phone_amount = free_phone_amount;
    }

    public String getFirmware() {
        return firmware;
    }

    public void setFirmware(String firmware) {
        this.firmware = firmware;
    }

    public Phone(int id, String name, String firmware, int free_phone_amount) {
        this.id = id;
        this.name = name;
        this.firmware = firmware;
        this.free_phone_amount = free_phone_amount;
    }
}
