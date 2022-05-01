package com.hotel.entites;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "U_ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int type;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String country;
    private String pinCode;

    @CreationTimestamp
    private Date createTs;

    @UpdateTimestamp
    private Date updateTs;
}