package com.snoopgame.application.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Employee(@NotNull String name, @NotNull String surname, @NotNull String middleName) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
    }

    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private String middleName;

    public Employee(){

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public long getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
