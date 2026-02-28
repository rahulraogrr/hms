package com.hotel.constants;

/**
 * HMS System Roles.
 *
 * <pre>
 *  SUPER_ADMIN  – full access to every resource
 *  HOTEL_ADMIN  – manage hotel operations (hotels, floors, rooms, departments, employees)
 *  HR_MANAGER   – manage people (employees, departments); read-only on structural resources
 *  FRONT_DESK   – read-only on all resources
 * </pre>
 */
public enum Role {
    SUPER_ADMIN,
    HOTEL_ADMIN,
    HR_MANAGER,
    FRONT_DESK
}
