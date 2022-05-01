package com.hotel.entites;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "A_HOTELS")
@Data
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private int status;
    private int noOfFloors;
    private Date openDate;

    @ManyToOne
    @JoinColumn(name = "hotel_group_id", referencedColumnName = "id")
    private Group group;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "hotel_address_id",referencedColumnName = "id")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotel", fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Floor> floors = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotel", fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Department> departments = new HashSet<>();
}