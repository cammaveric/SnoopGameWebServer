package com.snoopgame.application.Entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "phone")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    private String name;
    @NotNull
    private int amount;
    @NotNull
    private int free_phone_amount;
    @NotNull
    private String firmware_name;
    @NotNull
    private String firmware_version;

    public String getFullName(){
        return name+" "+firmware_name+" "+firmware_version;
    }
}
