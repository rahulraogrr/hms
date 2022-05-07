package com.hotel.repositories.admin;

import com.hotel.entites.admin.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Room Repository
 * @author rgonda
 */
@Repository
public interface RoomRepository extends JpaRepository<Room,Integer> {
}