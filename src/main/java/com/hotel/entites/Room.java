package com.hotel.entites;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "A_ROOMS")
@Data
public class Room implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int type;
    private int area;
    private int status;

    @ManyToOne
    @JoinColumn(name = "room_floor_id", referencedColumnName = "id")
    private Floor floor;
}