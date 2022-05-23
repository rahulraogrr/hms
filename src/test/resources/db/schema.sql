--
-- Table structure for u_address
--
DROP TABLE IF EXISTS u_address CASCADE;
CREATE TABLE u_address (
       id bigint NOT NULL,
        address1 varchar(255),
        address2 varchar(255),
        city varchar(255),
        country varchar(255),
        create_ts timestamp,
        pin_code varchar(255),
        state varchar(255),
        type integer NOT NULL,
        update_ts timestamp,
        PRIMARY KEY (id)
    )

--
-- Table structure for a_groups
--
DROP TABLE IF EXISTS a_groups CASCADE;
CREATE TABLE a_groups (
        id integer NOT NULL,
        create_ts timestamp,
        name varchar(20),
        status integer NOT NULL,
        update_ts timestamp,
        group_address_id bigint,
        PRIMARY KEY (id)
    );

ALTER TABLE a_groups
       ADD CONSTRAINT FK9i0p74dlwihdyytyp2q6mqa3l
       FOREIGN KEY (group_address_id)
       REFERENCES u_address

--
-- Table structure for a_hotels
--



