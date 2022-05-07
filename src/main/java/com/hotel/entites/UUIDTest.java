package com.hotel.entites;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "UUID_TEST")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UUIDTest implements Serializable {

    @Id
    @Type(type="org.hibernate.type.PostgresUUIDType")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    private String name;
}
