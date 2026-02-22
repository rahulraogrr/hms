package com.hotel.repositories.admin;

import com.hotel.entities.admin.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Address Repository
 * @author rgonda
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}