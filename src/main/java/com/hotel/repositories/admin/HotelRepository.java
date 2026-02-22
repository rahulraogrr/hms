package com.hotel.repositories.admin;

import com.hotel.entities.admin.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Hotel Repository
 * @author rgonda
 */
@Repository
public interface HotelRepository extends JpaRepository<Hotel,Integer> {

    /** Eager-join address and group to avoid N+1 on the browse-all endpoint. */
    @EntityGraph(attributePaths = {"address", "group"})
    Page<Hotel> findAll(Pageable pageable);
}