package com.hotel.entities.admin;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "A_HOTELS")
@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Hotel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    @SequenceGenerator(name = "global_seq", sequenceName = "GLOBAL_SEQUENCE")
    private int id;

    private String name;
    private int status;
    private int noOfFloors;

    @Temporal(TemporalType.DATE)
    private Date founded;

    @ManyToOne
    @JoinColumn(name = "hotel_group_id", referencedColumnName = "id")
    private Group group;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "hotel_address_id",referencedColumnName = "id")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotel", fetch = FetchType.LAZY, orphanRemoval = true)
    private final Set<Floor> floors = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotel", fetch = FetchType.LAZY, orphanRemoval = true)
    private final Set<Department> departments = new HashSet<>();

    @CreationTimestamp
    private Date createTs;

    @UpdateTimestamp
    private Date updateTs;
}