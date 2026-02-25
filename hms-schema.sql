-- ============================================================
--  HMS – Hotel Management System
--  PostgreSQL Database Schema
--  Generated from JPA entity definitions
-- ============================================================

-- ─────────────────────────────────────────────
--  DROP EXISTING OBJECTS (reverse FK order)
-- ─────────────────────────────────────────────
DROP TABLE IF EXISTS A_EMPLOYEES        CASCADE;
DROP TABLE IF EXISTS A_DEPARTMENTS      CASCADE;
DROP TABLE IF EXISTS A_ROOMS            CASCADE;
DROP TABLE IF EXISTS A_FLOORS           CASCADE;
DROP TABLE IF EXISTS A_RESORTS          CASCADE;
DROP TABLE IF EXISTS A_HOTELS           CASCADE;
DROP TABLE IF EXISTS A_GROUPS           CASCADE;
DROP TABLE IF EXISTS A_PARENT_COMPANIES CASCADE;
DROP TABLE IF EXISTS U_ADDRESS          CASCADE;

DROP SEQUENCE IF EXISTS EMP_SEQUENCE;
DROP SEQUENCE IF EXISTS GLOBAL_SEQUENCE;
DROP SEQUENCE IF EXISTS ADDRESS_SEQUENCE;


-- ─────────────────────────────────────────────
--  SEQUENCES
-- ─────────────────────────────────────────────
CREATE SEQUENCE IF NOT EXISTS ADDRESS_SEQUENCE START WITH 1 INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS GLOBAL_SEQUENCE  START WITH 1 INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS EMP_SEQUENCE     START WITH 1 INCREMENT BY 50;


-- ─────────────────────────────────────────────
--  U_ADDRESS
--  Shared address table used by all entities.
--  'type' differentiates permanent / current / billing etc.
-- ─────────────────────────────────────────────
CREATE TABLE U_ADDRESS (
    id         BIGINT       NOT NULL DEFAULT nextval('ADDRESS_SEQUENCE'),
    type       INT,
    address1   VARCHAR(255),
    address2   VARCHAR(255),
    city       VARCHAR(255),
    state      VARCHAR(255),
    country    VARCHAR(255),
    pin_code   VARCHAR(255),
    create_ts  TIMESTAMP,
    update_ts  TIMESTAMP,
    CONSTRAINT pk_address PRIMARY KEY (id)
);


-- ─────────────────────────────────────────────
--  A_PARENT_COMPANIES
--  Top-level owning company (PK manually assigned).
-- ─────────────────────────────────────────────
CREATE TABLE A_PARENT_COMPANIES (
    id                INT NOT NULL,
    name              VARCHAR(255),
    type              INT,
    isin              VARCHAR(255),
    industry          VARCHAR(255),
    founded           DATE,
    parent_address_id BIGINT,
    CONSTRAINT pk_parent     PRIMARY KEY (id),
    CONSTRAINT fk_parent_addr FOREIGN KEY (parent_address_id) REFERENCES U_ADDRESS(id)
);


-- ─────────────────────────────────────────────
--  A_GROUPS
-- ─────────────────────────────────────────────
CREATE TABLE A_GROUPS (
    id               INT NOT NULL DEFAULT nextval('GLOBAL_SEQUENCE'),
    name             VARCHAR(20),
    status           INT,
    group_address_id BIGINT,
    group_parent_id  INT,
    create_ts        TIMESTAMP,
    update_ts        TIMESTAMP,
    CONSTRAINT pk_group        PRIMARY KEY (id),
    CONSTRAINT fk_group_addr   FOREIGN KEY (group_address_id) REFERENCES U_ADDRESS(id),
    CONSTRAINT fk_group_parent FOREIGN KEY (group_parent_id)  REFERENCES A_PARENT_COMPANIES(id)
);


-- ─────────────────────────────────────────────
--  A_HOTELS
-- ─────────────────────────────────────────────
CREATE TABLE A_HOTELS (
    id               INT NOT NULL DEFAULT nextval('GLOBAL_SEQUENCE'),
    name             VARCHAR(255),
    status           INT,
    no_of_floors     INT,
    founded          DATE,
    hotel_group_id   INT,
    hotel_address_id BIGINT,
    create_ts        TIMESTAMP,
    update_ts        TIMESTAMP,
    CONSTRAINT pk_hotel       PRIMARY KEY (id),
    CONSTRAINT fk_hotel_group FOREIGN KEY (hotel_group_id)   REFERENCES A_GROUPS(id),
    CONSTRAINT fk_hotel_addr  FOREIGN KEY (hotel_address_id) REFERENCES U_ADDRESS(id)
);


-- ─────────────────────────────────────────────
--  A_RESORTS
-- ─────────────────────────────────────────────
CREATE TABLE A_RESORTS (
    id                INT          NOT NULL DEFAULT nextval('GLOBAL_SEQUENCE'),
    name              VARCHAR(255),
    status            INT,
    founded           DATE,
    resort_group_id   INT,
    resort_address_id BIGINT,
    create_ts         TIMESTAMP,
    update_ts         TIMESTAMP,
    CONSTRAINT pk_resort       PRIMARY KEY (id),
    CONSTRAINT fk_resort_group FOREIGN KEY (resort_group_id)   REFERENCES A_GROUPS(id),
    CONSTRAINT fk_resort_addr  FOREIGN KEY (resort_address_id) REFERENCES U_ADDRESS(id)
);


-- ─────────────────────────────────────────────
--  A_FLOORS
-- ─────────────────────────────────────────────
CREATE TABLE A_FLOORS (
    id             INT  NOT NULL DEFAULT nextval('GLOBAL_SEQUENCE'),
    no_of_rooms    INT,
    status         INT,
    floor_hotel_id INT,
    create_ts      TIMESTAMP,
    update_ts      TIMESTAMP,
    CONSTRAINT pk_floor       PRIMARY KEY (id),
    CONSTRAINT fk_floor_hotel FOREIGN KEY (floor_hotel_id) REFERENCES A_HOTELS(id)
);


-- ─────────────────────────────────────────────
--  A_ROOMS
-- ─────────────────────────────────────────────
CREATE TABLE A_ROOMS (
    id            INT  NOT NULL DEFAULT nextval('GLOBAL_SEQUENCE'),
    type          INT,
    area          INT,
    status        INT,
    room_floor_id INT,
    create_ts     TIMESTAMP,
    update_ts     TIMESTAMP,
    CONSTRAINT pk_room       PRIMARY KEY (id),
    CONSTRAINT fk_room_floor FOREIGN KEY (room_floor_id) REFERENCES A_FLOORS(id)
);


-- ─────────────────────────────────────────────
--  A_DEPARTMENTS
--  Belongs to either a Hotel or a Resort (nullable FK).
-- ─────────────────────────────────────────────
CREATE TABLE A_DEPARTMENTS (
    id             INT          NOT NULL DEFAULT nextval('GLOBAL_SEQUENCE'),
    type           INT,
    name           VARCHAR(255),
    status         INT,
    dept_hotel_id  INT,
    resort_hotel_id INT,
    create_ts      TIMESTAMP,
    update_ts      TIMESTAMP,
    CONSTRAINT pk_dept        PRIMARY KEY (id),
    CONSTRAINT fk_dept_hotel  FOREIGN KEY (dept_hotel_id)   REFERENCES A_HOTELS(id),
    CONSTRAINT fk_dept_resort FOREIGN KEY (resort_hotel_id) REFERENCES A_RESORTS(id)
);


-- ─────────────────────────────────────────────
--  A_EMPLOYEES
--  Self-referencing 'reports_to' for manager hierarchy.
--  Two address FK's: permanent and current.
-- ─────────────────────────────────────────────
CREATE TABLE A_EMPLOYEES (
    id                       BIGINT       NOT NULL DEFAULT nextval('EMP_SEQUENCE'),
    first_name               VARCHAR(255),
    middle_name              VARCHAR(255),
    last_name                VARCHAR(255),
    date_of_birth            DATE,
    edu_type                 INT,
    hire_date                DATE,
    last_date                DATE,
    id_type                  INT,
    id_no                    VARCHAR(255),
    mobile                   VARCHAR(255),
    gender                   VARCHAR(50),
    designation              INT,
    status                   INT,
    curr_add_same_as_perm_add BOOLEAN,
    grade                    INT,
    reports_to               BIGINT,          -- self-ref: manager
    emp_dept_id              INT,
    emp_perm_add_id          BIGINT,
    emp_cur_add_id           BIGINT,
    create_ts                TIMESTAMP,
    update_ts                TIMESTAMP,
    CONSTRAINT pk_employee       PRIMARY KEY (id),
    CONSTRAINT fk_emp_manager    FOREIGN KEY (reports_to)      REFERENCES A_EMPLOYEES(id),
    CONSTRAINT fk_emp_dept       FOREIGN KEY (emp_dept_id)     REFERENCES A_DEPARTMENTS(id),
    CONSTRAINT fk_emp_perm_addr  FOREIGN KEY (emp_perm_add_id) REFERENCES U_ADDRESS(id),
    CONSTRAINT fk_emp_cur_addr   FOREIGN KEY (emp_cur_add_id)  REFERENCES U_ADDRESS(id)
);


-- ─────────────────────────────────────────────
--  INDEXES  (recommended for FK columns)
-- ─────────────────────────────────────────────
CREATE INDEX IF NOT EXISTS idx_group_parent    ON A_GROUPS(group_parent_id);
CREATE INDEX IF NOT EXISTS idx_hotel_group     ON A_HOTELS(hotel_group_id);
CREATE INDEX IF NOT EXISTS idx_resort_group    ON A_RESORTS(resort_group_id);
CREATE INDEX IF NOT EXISTS idx_floor_hotel     ON A_FLOORS(floor_hotel_id);
CREATE INDEX IF NOT EXISTS idx_room_floor      ON A_ROOMS(room_floor_id);
CREATE INDEX IF NOT EXISTS idx_dept_hotel      ON A_DEPARTMENTS(dept_hotel_id);
CREATE INDEX IF NOT EXISTS idx_dept_resort     ON A_DEPARTMENTS(resort_hotel_id);
CREATE INDEX IF NOT EXISTS idx_emp_dept        ON A_EMPLOYEES(emp_dept_id);
CREATE INDEX IF NOT EXISTS idx_emp_manager     ON A_EMPLOYEES(reports_to);
