package com.hotel.repositories;

import com.hotel.entites.admin.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Employee Repository
 * @author rgonda
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
