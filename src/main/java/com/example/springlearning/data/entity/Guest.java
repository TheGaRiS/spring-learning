package com.example.springlearning.data.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(schema = "learn", name = "GUEST")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "guest_id")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_address")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @Column(name = "phone_number")
    private String phoneNumber;
}
