package com.hotel.entites;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "A_FLOORS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Floor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String noOfRooms;
    private int status;

    @ManyToOne
    @JoinColumn(name = "floor_hotel_id", referencedColumnName = "id")
    private Hotel hotel;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "floor", fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Room> rooms = new HashSet<>();

    @CreationTimestamp
    private Date createTs;

    @UpdateTimestamp
    private Date updateTs;
}