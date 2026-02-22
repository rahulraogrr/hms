package com.hotel.repositories.admin;

import com.hotel.entities.admin.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Group Repository
 * @author rgonda
 */
@Repository
public interface GroupRepository extends JpaRepository<Group,Integer> {

    /** Eager-join address to avoid N+1 on the browse-all endpoint. */
    @EntityGraph(attributePaths = {"address"})
    Page<Group> findAll(Pageable pageable);
}