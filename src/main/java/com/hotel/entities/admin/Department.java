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
@Table(name = "A_DEPARTMENTS")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Department implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    @SequenceGenerator(name = "global_seq", sequenceName = "GLOBAL_SEQUENCE")
    private int id;

    private int type;
    private String name;
    private int status;

    @ManyToOne
    @JoinColumn(name = "dept_hotel_id", referencedColumnName = "id")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "resort_hotel_id", referencedColumnName = "id")
    private Resort resort;

    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private final Set<Employee> employees = new HashSet<>();

    @CreationTimestamp
    private Date createTs;

    @UpdateTimestamp
    private Date updateTs;
}