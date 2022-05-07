package com.hotel.repositories;

import com.hotel.entites.admin.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Group Repository
 * @author rgonda
 */
@Repository
public interface GroupRepository extends JpaRepository<Group,Integer> {
}