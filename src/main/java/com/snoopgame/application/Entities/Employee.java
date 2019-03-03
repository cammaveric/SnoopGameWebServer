package com.snoopgame.application.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private String middleName;

    public Employee(@NotNull String name, @NotNull String surname, @NotNull String middleName) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
    }

    public Employee() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
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


    public String getMiddleName() {
        return middleName;
    }
    public String getFio(){
        return surname+" "+name+" "+middleName;
    }
}
