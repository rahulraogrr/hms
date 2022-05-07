package com.hotel.repositories.admin;

import com.hotel.entites.admin.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Hotel Repository
 * @author rgonda
 */
@Repository
public interface HotelRepository extends JpaRepository<Hotel,Integer> {

}