--
-- DROP TABLES if they already exists
--
DROP TABLE if EXISTS a_departments CASCADE;
DROP TABLE if EXISTS a_employees CASCADE;
DROP TABLE if EXISTS a_floors CASCADE;
DROP TABLE if EXISTS a_groups CASCADE;
DROP TABLE if EXISTS a_hotels CASCADE;
DROP TABLE if EXISTS a_parent_companies CASCADE;
DROP TABLE if EXISTS a_resorts CASCADE;
DROP TABLE if EXISTS a_rooms CASCADE;
DROP TABLE if EXISTS u_address CASCADE;
DROP TABLE if EXISTS uuid_test CASCADE;
DROP sequence if EXISTS address_sequence;
DROP sequence if EXISTS emp_sequence;
DROP sequence if EXISTS global_sequence;

--
-- CREATE SEQUENCES
--
CREATE sequence address_sequence start WITH 1 increment by 50;
CREATE sequence emp_sequence start WITH 1 increment by 50;
CREATE sequence global_sequence start WITH 1 increment by 50;


--
-- CREATE TABLES and its keys
--

--
-- Create u_address
--
CREATE TABLE u_address (
       id bigint NOT NULL,
        address1 varchar(255),
        address2 varchar(255),
        city varchar(255),
        country varchar(255),
        create_ts timestamp,
        pin_code varchar(255),
        state varchar(255),
        "type" integer NOT NULL,
        update_ts timestamp,
        PRIMARY KEY (id)
);

--
-- Create a_parent_companies
--
CREATE TABLE a_parent_companies (
       id integer NOT NULL,
        founded date,
        isin varchar(255),
        industry varchar(255),
        "name" varchar(255),
        "type" integer NOT NULL,
        parent_address_id bigint,
        PRIMARY KEY (id)
);

--
-- Create a_departments
--
CREATE TABLE a_departments (
       id integer NOT NULL,
        create_ts timestamp,
        "name" varchar(255),
        status integer NOT NULL,
        "type" integer NOT NULL,
        update_ts timestamp,
        dept_hotel_id integer,
        resort_hotel_id integer,
        PRIMARY KEY (id)
);

--
-- Create a_employees
--
CREATE TABLE a_employees (
       id bigint NOT NULL,
        create_ts timestamp,
        curr_add_same_as_perm_add boolean NOT NULL,
        date_of_birth date,
        designation integer NOT NULL,
        edu_type integer NOT NULL,
        first_name varchar(255),
        gender integer,
        grade integer NOT NULL,
        hire_date date,
        id_no varchar(255),
        id_type integer NOT NULL,
        last_date date,
        last_name varchar(255),
        middle_name varchar(255),
        mobile varchar(255),
        reports_to bigint NOT NULL,
        status integer NOT NULL,
        update_ts timestamp,
        emp_cur_add_id bigint,
        emp_dept_id integer,
        emp_perm_add_id bigint,
        PRIMARY KEY (id)
);

--
-- Create a_floors
--
CREATE TABLE a_floors (
       id integer NOT NULL,
        create_ts timestamp,
        no_of_rooms integer NOT NULL,
        status integer NOT NULL,
        update_ts timestamp,
        floor_hotel_id integer,
        PRIMARY KEY (id)
);

--
-- Create a_groups
--
CREATE TABLE a_groups (
       id integer NOT NULL,
        create_ts timestamp,
        "name" varchar(20),
        status integer NOT NULL,
        update_ts timestamp,
        group_address_id bigint,
        group_parent_id integer,
        PRIMARY KEY (id)
);

--
-- Create a_hotels
--
CREATE TABLE a_hotels (
       id integer NOT NULL,
        create_ts timestamp,
        founded date,
        "name" varchar(255),
        no_of_floors integer NOT NULL,
        status integer NOT NULL,
        update_ts timestamp,
        hotel_address_id bigint,
        hotel_group_id integer,
        PRIMARY KEY (id)
);

--
-- Create a_resorts
--
CREATE TABLE a_resorts (
       id integer NOT NULL,
        create_ts timestamp,
        founded date,
        "name" varchar(255),
        status integer NOT NULL,
        update_ts timestamp,
        resort_address_id bigint,
        resort_group_id integer,
        PRIMARY KEY (id)
);

--
-- Create a_rooms
--
CREATE TABLE a_rooms (
       id integer NOT NULL,
        area integer NOT NULL,
        create_ts timestamp,
        status integer NOT NULL,
        "type" integer NOT NULL,
        update_ts timestamp,
        room_floor_id integer,
        PRIMARY KEY (id)
);

--
-- Create uuid_test
--
CREATE TABLE uuid_test (
       uuid binary NOT NULL,
        "name" varchar(255),
        PRIMARY KEY (uuid)
);

--
-- CREATE FOREIGN KEYS
--
ALTER TABLE a_rooms
       ADD CONSTRAINT FKj6r14axdm54aeehk27hh3s3fn
       FOREIGN KEY (room_floor_id)
       REFERENCES a_floors;

ALTER TABLE a_departments
       ADD CONSTRAINT FKlkl286328qonpnysnhich5d6g
       FOREIGN KEY (dept_hotel_id)
       REFERENCES a_hotels;

ALTER TABLE a_departments
       ADD CONSTRAINT FKcvtkodhketi4ludwvr3o8m58q
       FOREIGN KEY (resort_hotel_id)
       REFERENCES a_resorts;

ALTER TABLE a_parent_companies
       ADD CONSTRAINT FKennjld7y3jmgfnnd3ho43nlxw
       FOREIGN KEY (parent_address_id)
       REFERENCES u_address;

ALTER TABLE a_employees
       ADD CONSTRAINT FKohid0xf535623d1g7c7vwv0e2
       FOREIGN KEY (emp_cur_add_id)
       REFERENCES u_address;

ALTER TABLE a_employees
       ADD CONSTRAINT FKrkjq0arrfwj1vwg29ywcfw74k
       FOREIGN KEY (emp_perm_add_id)
       REFERENCES u_address;

ALTER TABLE a_employees
       ADD CONSTRAINT FKhcpqixwir8cky38g96n46mri6
       FOREIGN KEY (emp_dept_id)
       REFERENCES a_departments;

ALTER TABLE a_floors
       ADD CONSTRAINT FK3k9kecgp35omuc09rb37yyc5a
       FOREIGN KEY (floor_hotel_id)
       REFERENCES a_hotels;

ALTER TABLE a_groups
       ADD CONSTRAINT FK9i0p74dlwihdyytyp2q6mqa3l
       FOREIGN KEY (group_address_id)
       REFERENCES u_address;

ALTER TABLE a_groups
       ADD CONSTRAINT FKcybpf34cg70iu1lin52vqcfdi
       FOREIGN KEY (group_parent_id)
       REFERENCES a_parent_companies;

ALTER TABLE a_hotels
       ADD CONSTRAINT FK3yah2w7vpks3l5bk7us4gpkmr
       FOREIGN KEY (hotel_address_id)
       REFERENCES u_address;

ALTER TABLE a_hotels
       ADD CONSTRAINT FK6w728un5s4ah4fioe2u7f2yhy
       FOREIGN KEY (hotel_group_id)
       REFERENCES a_groups;

ALTER TABLE a_resorts
       ADD CONSTRAINT FKadlk6h3txpry9gawydoqj1pko
       FOREIGN KEY (resort_address_id)
       REFERENCES u_address;

ALTER TABLE a_resorts
       ADD CONSTRAINT FK4p43m8pva0wv8vw34k3wiwha5
       FOREIGN KEY (resort_group_id)
       REFERENCES a_groups;

