package com.hotel.entities.admin;

import lombok.*;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@Entity
@Table(name = "A_PARENT_COMPANIES")
@AllArgsConstructor
public class Parent implements Serializable {
    @Id
    private int id;
    private String name;
    private int type;
    @Column(name = "isin")
    private String isin;
    private String industry;

    @Temporal(TemporalType.DATE)
    private Date founded;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "parent_address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent", fetch = FetchType.LAZY, orphanRemoval = true)
    private final Set<Group> groups = new HashSet<>();
}