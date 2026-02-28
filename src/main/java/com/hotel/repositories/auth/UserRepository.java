package com.hotel.repositories.auth;

import com.hotel.entities.auth.HmsUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<HmsUser, Long> {
    Optional<HmsUser> findByUsername(String username);
}
