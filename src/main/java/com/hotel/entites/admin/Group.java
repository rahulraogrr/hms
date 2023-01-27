package com.hotel.entites.admin;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "A_GROUPS")
@Setter
@Getter
@NoArgsConstructor
public class Group implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    @SequenceGenerator(name = "global_seq", sequenceName = "GLOBAL_SEQUENCE")
    private int id;

    @Column(name = "name", length = 20)
    private String name;

    private int status;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "group_address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group", fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Hotel> hotels = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "group_parent_id", referencedColumnName = "id")
    private Parent parent;

    @CreationTimestamp
    private Date createTs;

    @UpdateTimestamp
    private Date updateTs;

    public Group(int id, String name, int status, Address address) {
        this.id=id;
        this.name=name;
        this.status=status;
        this.address=address;
    }
}