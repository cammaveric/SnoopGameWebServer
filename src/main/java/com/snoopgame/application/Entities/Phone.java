package com.snoopgame.application.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int amount;
    private int free_phone_amount;
    private String firmware;

    public Phone() {
    }

    public Phone(String name, int amount, int free_phone_amount, String firmware) {
        this.name = name;
        this.amount = amount;
        this.free_phone_amount = free_phone_amount;
        this.firmware = firmware;
    }

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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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
}
