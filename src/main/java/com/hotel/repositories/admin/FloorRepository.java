package com.hotel.repositories.admin;

import com.hotel.entities.admin.Floor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Floor Repository
 * @author rgonda
 */
@Repository
public interface FloorRepository extends JpaRepository<Floor, Integer> {

    /** Eager-join hotel to avoid N+1 on the browse-all endpoint. */
    @EntityGraph(attributePaths = {"hotel"})
    Page<Floor> findAll(Pageable pageable);
}