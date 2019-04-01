package com.snoopgame.application.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "order_phone")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @NonNull
    private String date_start;
    private String date_end = null;
    @NotNull
    @NonNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_fk", referencedColumnName = "id")
    private Employee employee;
    @NotNull
    @NonNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "phone_fk", referencedColumnName = "id")
    private Phone phone;
    @NotNull
    @NonNull
    @Enumerated(EnumType.STRING)
    private Status status;

}

