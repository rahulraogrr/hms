package com.hotel.entites;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "A_DEPARTMENTS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Employee> employees = new HashSet<>();

    @CreationTimestamp
    private Date createTs;

    @UpdateTimestamp
    private Date updateTs;
}