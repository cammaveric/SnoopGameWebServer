package com.snoopgame.application.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "order_phone")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String date_start;
    private Timestamp date_end;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_fk", referencedColumnName = "id")
    private Employee employee;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "phone_fk", referencedColumnName = "id")
    private Phone phone;
    @ElementCollection(targetClass = Status.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "order_status", joinColumns = @JoinColumn(name = "order_id"))
    @Enumerated(EnumType.STRING)
    private Set<Status> statuses;

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate_start(String date_start) {
        this.date_start = date_start;
    }

    public Timestamp getDate_end() {
        return date_end;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public void setStatuses(Set<Status> statuses) {
        this.statuses = statuses;
    }

    public Order(@NotNull String date_start, Timestamp date_end, Employee employee, Phone phone, Set<Status> statuses) {
        this.date_start = date_start;
        this.date_end = date_end;
        this.employee = employee;
        this.phone = phone;
        this.statuses = statuses;
    }


    public Employee getEmployee() {
        return employee;
    }


    public Phone getPhone() {
        return phone;
    }


    public String getDate_start() {
        return date_start;
    }


    public void setDate_end(Timestamp date_end) {
        this.date_end = date_end;
    }

    public Set<Status> getStatuses() {
        return statuses;
    }

}

