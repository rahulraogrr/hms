package com.hotel.repositories.admin;

import com.hotel.entites.admin.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Department Repository
 * @author rgonda
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}