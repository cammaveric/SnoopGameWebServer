package com.snoopgame.application.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "phone")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private String name;
    @NotNull
    private int amount;
    @NotNull
    private int free_phone_amount;
    @NotNull
    private String firmware;

    public Phone(@NotNull String name, @NotNull int amount, @NotNull int free_phone_amount, @NotNull String firmware) {
        this.name = name;
        this.amount = amount;
        this.free_phone_amount = free_phone_amount;
        this.firmware = firmware;
    }

    public Phone() {
    }


    public long getId() {
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
