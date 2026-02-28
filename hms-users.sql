-- =============================================================================
-- HMS_USERS table DDL + seed data
-- Run this ONCE before starting the Spring Boot application.
-- Password for all users: Admin@123 (BCrypt, cost 12)
-- =============================================================================

-- Drop and recreate the users table
DROP TABLE IF EXISTS HMS_USERS;

CREATE TABLE HMS_USERS (
    id                      BIGSERIAL       PRIMARY KEY,
    username                VARCHAR(50)     NOT NULL UNIQUE,
    password                VARCHAR(255)    NOT NULL,
    email                   VARCHAR(100)    NOT NULL UNIQUE,
    full_name               VARCHAR(100),
    role                    VARCHAR(30)     NOT NULL,
    enabled                 BOOLEAN         NOT NULL DEFAULT TRUE,
    account_non_expired     BOOLEAN         NOT NULL DEFAULT TRUE,
    account_non_locked      BOOLEAN         NOT NULL DEFAULT TRUE,
    credentials_non_expired BOOLEAN         NOT NULL DEFAULT TRUE,
    create_ts               TIMESTAMP,
    update_ts               TIMESTAMP
);

-- =============================================================================
-- Seed users  (all passwords = Admin@123, BCrypt cost 12)
-- =============================================================================

-- SUPER_ADMIN — full access to everything
INSERT INTO HMS_USERS (username, password, email, full_name, role)
VALUES ('superadmin',
        '$2b$12$RfEN5DdofVkuY67Y3FYhQuChXYBpjMui3BzGMLKiLgp0zmgzs4V6m',
        'superadmin@hms.com', 'Super Admin', 'SUPER_ADMIN');

-- HOTEL_ADMIN — manage hotel ops (hotels, floors, rooms, departments, employees)
INSERT INTO HMS_USERS (username, password, email, full_name, role)
VALUES ('hoteladmin',
        '$2b$12$afEcZ2FrBdzze6Zh3IXDaO1b9pFr3XjYytQCTlWx4u99GXfdjTMZa',
        'hoteladmin@hms.com', 'Hotel Admin', 'HOTEL_ADMIN');

-- HR_MANAGER — manage employees and departments; read-only on structural resources
INSERT INTO HMS_USERS (username, password, email, full_name, role)
VALUES ('hrmanager',
        '$2b$12$xctXTl0/PXuCNEUwcRV/aeow4YDqgCheNgVqKVegfax.sF4lhFjWG',
        'hr@hms.com', 'HR Manager', 'HR_MANAGER');

-- FRONT_DESK — read-only on all resources
INSERT INTO HMS_USERS (username, password, email, full_name, role)
VALUES ('frontdesk',
        '$2b$12$U2WbY2FTz/fqYn5r0NLDGO2yZj5f.yd.M0/.5R9ZH8PcgRz9E8XSS',
        'frontdesk@hms.com', 'Front Desk', 'FRONT_DESK');
