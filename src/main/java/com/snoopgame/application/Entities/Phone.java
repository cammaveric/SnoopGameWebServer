package com.snoopgame.application.Entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "phone")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    @NonNull
    private String name;
    @NotNull
    @NonNull
    private int amount;
    @NotNull
    @NonNull
    private int free_phone_amount;
    @NotNull
    @NonNull
    private String firmware_name;
    @NotNull
    @NonNull
    private String firmware_version;

    public String getFullName(){
        return name+" "+firmware_name+" "+firmware_version;
    }
}
