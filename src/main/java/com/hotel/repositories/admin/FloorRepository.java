package com.hotel.repositories.admin;

import com.hotel.entites.admin.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Floor Repository
 * @author rgonda
 */
@Repository
public interface FloorRepository extends JpaRepository<Floor, Integer> {
}