package com.hotel.repositories.admin;

import com.hotel.entities.admin.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Employee Repository
 * @author rgonda
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    /** Eager-join department and addresses to avoid N+1 on the browse-all endpoint. */
    @EntityGraph(attributePaths = {"department", "permAddress", "curAddress"})
    Page<Employee> findAll(Pageable pageable);
}
