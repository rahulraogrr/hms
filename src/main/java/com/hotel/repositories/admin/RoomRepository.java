package com.hotel.repositories.admin;

import com.hotel.entities.admin.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Room Repository
 * @author rgonda
 */
@Repository
public interface RoomRepository extends JpaRepository<Room,Integer> {

    /** Eager-join floor to avoid N+1 on the browse-all endpoint. */
    @EntityGraph(attributePaths = {"floor"})
    Page<Room> findAll(Pageable pageable);
}