package com.hotel.repositories;

import com.hotel.entites.admin.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Address Repository
 * @author rgonda
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}