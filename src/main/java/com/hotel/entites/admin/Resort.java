package com.hotel.entites.admin;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "A_RESORTS")
@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Resort implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    @SequenceGenerator(name = "global_seq", sequenceName = "GLOBAL_SEQUENCE")
    private int id;

    private String name;
    private int status;

    @Temporal(TemporalType.DATE)
    private Date founded;

    @ManyToOne
    @JoinColumn(name = "resort_group_id", referencedColumnName = "id")
    private Group group;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "resort_address_id",referencedColumnName = "id")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resort", fetch = FetchType.LAZY, orphanRemoval = true)
    private final Set<Department> departments = new HashSet<>();

    @CreationTimestamp
    private Date createTs;

    @UpdateTimestamp
    private Date updateTs;
}