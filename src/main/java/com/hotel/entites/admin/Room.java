package com.hotel.entites.admin;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "A_ROOMS")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Room implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    @SequenceGenerator(name = "global_seq", sequenceName = "GLOBAL_SEQUENCE")
    private int id;

    private int type;
    private int area;
    private int status;

    @ManyToOne
    @JoinColumn(name = "room_floor_id", referencedColumnName = "id")
    private Floor floor;

    @CreationTimestamp
    private Date createTs;

    @UpdateTimestamp
    private Date updateTs;
}