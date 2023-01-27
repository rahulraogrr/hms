package com.hotel.entites.admin;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "U_ADDRESS")
@Getter
@Setter
@NoArgsConstructor
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_generator")
    @SequenceGenerator(name = "address_generator", sequenceName = "ADDRESS_SEQUENCE")
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

    public Address(String address1, String address2, int type, String city,
                   String state, String country, String pinCode) {
        this.address1=address1;
        this.address2=address2;
        this.type=type;
        this.city=city;
        this.state=state;
        this.country=country;
        this.pinCode=pinCode;
    }
}