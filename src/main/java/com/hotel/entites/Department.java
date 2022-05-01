package com.hotel.entites;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "A_DEPARTMENTS")
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int type;
    private String name;
    private int status;

    @ManyToOne
    @JoinColumn(name = "dept_hotel_id", referencedColumnName = "id")
    private Hotel hotel;

    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Employee> employees = new HashSet<>();
}