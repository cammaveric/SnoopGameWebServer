package com.snoopgame.application.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Employee employee;
    private Phone phone;
    private String date_start;/*Нужно тестить какой класс*/
    private String date_end;
    private Status status;
    public int getId() {
        return id;
    }
    public Order(){

    }
    public Order(int id, Employee employee, Phone phone, String date_start, String date_end, Status status) {
        this.id = id;
        this.employee = employee;
        this.phone = phone;
        this.date_start = date_start;
        this.date_end = date_end;
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public String getDate_start() {
        return date_start;
    }

    public void setDate_start(String date_start) {
        this.date_start = date_start;
    }

    public String getDate_end() {
        return date_end;
    }

    public void setDate_end(String date_end) {
        this.date_end = date_end;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

