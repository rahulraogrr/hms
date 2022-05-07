package com.hotel.repositories;

import com.hotel.entites.UUIDTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UUIDRepo extends JpaRepository<UUIDTest, UUID> {

}
