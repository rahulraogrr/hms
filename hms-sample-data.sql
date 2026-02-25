-- ============================================================
--  HMS – Hotel Management System
--  Sample Data
-- ============================================================


-- ─────────────────────────────────────────────
--  U_ADDRESS  (inserted first — referenced by all)
--  type: 1=Office/Property, 2=Permanent, 3=Current
-- ─────────────────────────────────────────────
INSERT INTO U_ADDRESS (id, type, address1, address2, city, state, country, pin_code, create_ts, update_ts) VALUES
-- Parent company address
(1,  1, '100 Corporate Blvd',   NULL,            'New York',    'NY',         'USA',   '10001', NOW(), NOW()),
-- Group addresses
(2,  1, '200 Luxury Ave',       'Suite 500',     'Los Angeles', 'CA',         'USA',   '90001', NOW(), NOW()),
(3,  1, '300 Heritage Road',    NULL,            'London',      'England',    'UK',    'EC1A1', NOW(), NOW()),
-- Hotel addresses
(4,  1, '10 Grand Plaza',       NULL,            'New York',    'NY',         'USA',   '10002', NOW(), NOW()),
(5,  1, '55 Sunset Strip',      'Tower B',       'Los Angeles', 'CA',         'USA',   '90028', NOW(), NOW()),
(6,  1, '1 Buckingham Gate',    NULL,            'London',      'England',    'UK',    'SW1E6', NOW(), NOW()),
(7,  1, '22 Marina Bay',        NULL,            'Singapore',   'Singapore',  'SGP',   '018956',NOW(), NOW()),
-- Resort address
(8,  1, '5 Beach Road',         'Villa Block',   'Miami',       'FL',         'USA',   '33101', NOW(), NOW()),
-- ── Employee permanent addresses (one unique row per employee) ──
(9,  2, '45 Elm Street',        'Apt 3B',        'New York',    'NY',         'USA',   '10003', NOW(), NOW()),  -- emp 601 perm
(10, 2, '12 Oak Lane',          NULL,            'Los Angeles', 'CA',         'USA',   '90002', NOW(), NOW()),  -- emp 602 perm
(11, 2, '7 Rose Gardens',       NULL,            'London',      'England',    'UK',    'W1A1',  NOW(), NOW()),  -- emp 603 perm
(12, 2, '88 Orchard Road',      '#05-01',        'Singapore',   'Singapore',  'SGP',   '238839',NOW(), NOW()),  -- emp 604 perm
(13, 2, '99 Maple Drive',       NULL,            'New York',    'NY',         'USA',   '10004', NOW(), NOW()),  -- emp 605 perm
(14, 2, '31 Park Avenue',       'Apt 7A',        'New York',    'NY',         'USA',   '10005', NOW(), NOW()),  -- emp 606 perm
(15, 2, '67 Willow Court',      NULL,            'Los Angeles', 'CA',         'USA',   '90003', NOW(), NOW()),  -- emp 607 perm
(16, 2, '14 Camden Road',       'Flat 2',        'London',      'England',    'UK',    'NW1 9',  NOW(), NOW()), -- emp 608 perm
(17, 2, '30 Tanjong Pagar',     '#08-12',        'Singapore',   'Singapore',  'SGP',   '088442',NOW(), NOW()),  -- emp 609 perm
(18, 2, '5 Hudson Yards',       'Unit 4C',       'New York',    'NY',         'USA',   '10001', NOW(), NOW()),  -- emp 610 perm
-- ── Employee current addresses (one unique row per employee) ──
(19, 3, '45 Elm Street',        'Apt 3B',        'New York',    'NY',         'USA',   '10003', NOW(), NOW()),  -- emp 601 cur
(20, 3, '200 West 34th Street', 'Floor 12',      'New York',    'NY',         'USA',   '10001', NOW(), NOW()),  -- emp 602 cur
(21, 3, '7 Rose Gardens',       NULL,            'London',      'England',    'UK',    'W1A1',  NOW(), NOW()),  -- emp 603 cur
(22, 3, '88 Orchard Road',      '#05-01',        'Singapore',   'Singapore',  'SGP',   '238839',NOW(), NOW()),  -- emp 604 cur
(23, 3, '99 Maple Drive',       NULL,            'New York',    'NY',         'USA',   '10004', NOW(), NOW()),  -- emp 605 cur
(24, 3, '31 Park Avenue',       'Apt 7A',        'New York',    'NY',         'USA',   '10005', NOW(), NOW()),  -- emp 606 cur
(25, 3, '67 Willow Court',      NULL,            'Los Angeles', 'CA',         'USA',   '90003', NOW(), NOW()),  -- emp 607 cur
(26, 3, '14 Camden Road',       'Flat 2',        'London',      'England',    'UK',    'NW1 9',  NOW(), NOW()), -- emp 608 cur
(27, 3, '30 Tanjong Pagar',     '#08-12',        'Singapore',   'Singapore',  'SGP',   '088442',NOW(), NOW()),  -- emp 609 cur
(28, 3, '5 Hudson Yards',       'Unit 4C',       'New York',    'NY',         'USA',   '10001', NOW(), NOW());  -- emp 610 cur

SELECT setval('ADDRESS_SEQUENCE', 200);


-- ─────────────────────────────────────────────
--  A_PARENT_COMPANIES
-- ─────────────────────────────────────────────
INSERT INTO A_PARENT_COMPANIES (id, name, type, isin, industry, founded, parent_address_id) VALUES
(1, 'Luxe Hospitality Corp',  1, 'US5478341024', 'Hospitality', '1985-06-15', 1);


-- ─────────────────────────────────────────────
--  A_GROUPS
-- ─────────────────────────────────────────────
INSERT INTO A_GROUPS (id, name, status, group_address_id, group_parent_id, create_ts, update_ts) VALUES
(1, 'Luxe Americas',  1, 2, 1, NOW(), NOW()),
(2, 'Luxe Europe',    1, 3, 1, NOW(), NOW());


-- ─────────────────────────────────────────────
--  A_HOTELS
-- ─────────────────────────────────────────────
INSERT INTO A_HOTELS (id, name, status, no_of_floors, founded, hotel_group_id, hotel_address_id, create_ts, update_ts) VALUES
(101, 'Luxe Grand New York',   1, 20, '2000-03-10', 1, 4, NOW(), NOW()),
(102, 'Luxe Sunset LA',        1, 15, '2005-07-22', 1, 5, NOW(), NOW()),
(103, 'Luxe London Palace',    1, 12, '1998-11-01', 2, 6, NOW(), NOW()),
(104, 'Luxe Marina Singapore', 1, 30, '2010-01-18', 2, 7, NOW(), NOW());


-- ─────────────────────────────────────────────
--  A_RESORTS
-- ─────────────────────────────────────────────
INSERT INTO A_RESORTS (id, name, status, founded, resort_group_id, resort_address_id, create_ts, update_ts) VALUES
(201, 'Luxe Miami Beach Resort', 1, '2015-05-20', 1, 8, NOW(), NOW());


-- ─────────────────────────────────────────────
--  A_FLOORS
-- ─────────────────────────────────────────────
INSERT INTO A_FLOORS (id, no_of_rooms, status, floor_hotel_id, create_ts, update_ts) VALUES
-- Luxe Grand New York (hotel 101) – 3 sample floors
(301, 10, 1, 101, NOW(), NOW()),
(302, 10, 1, 101, NOW(), NOW()),
(303, 10, 1, 101, NOW(), NOW()),
-- Luxe Sunset LA (hotel 102) – 2 sample floors
(304, 8,  1, 102, NOW(), NOW()),
(305, 8,  1, 102, NOW(), NOW()),
-- Luxe London Palace (hotel 103) – 2 sample floors
(306, 6,  1, 103, NOW(), NOW()),
(307, 6,  1, 103, NOW(), NOW()),
-- Luxe Marina Singapore (hotel 104) – 2 sample floors
(308, 12, 1, 104, NOW(), NOW()),
(309, 12, 1, 104, NOW(), NOW());


-- ─────────────────────────────────────────────
--  A_ROOMS
--  type: 1=Standard, 2=Deluxe, 3=Suite, 4=Presidential
--  area in sq ft
-- ─────────────────────────────────────────────
INSERT INTO A_ROOMS (id, type, area, status, room_floor_id, create_ts, update_ts) VALUES
-- Floor 301 (NY hotel, floor 1)
(401, 1, 350,  1, 301, NOW(), NOW()),
(402, 1, 350,  1, 301, NOW(), NOW()),
(403, 2, 500,  1, 301, NOW(), NOW()),
(404, 2, 500,  1, 301, NOW(), NOW()),
(405, 3, 800,  1, 301, NOW(), NOW()),
-- Floor 302 (NY hotel, floor 2)
(406, 1, 350,  1, 302, NOW(), NOW()),
(407, 2, 500,  1, 302, NOW(), NOW()),
(408, 3, 800,  1, 302, NOW(), NOW()),
(409, 4, 1500, 1, 302, NOW(), NOW()),
-- Floor 304 (LA hotel, floor 1)
(410, 1, 320,  1, 304, NOW(), NOW()),
(411, 2, 480,  1, 304, NOW(), NOW()),
(412, 3, 750,  1, 304, NOW(), NOW()),
-- Floor 306 (London hotel, floor 1)
(413, 1, 300,  1, 306, NOW(), NOW()),
(414, 2, 450,  1, 306, NOW(), NOW()),
(415, 3, 700,  1, 306, NOW(), NOW()),
-- Floor 308 (Singapore hotel, floor 1)
(416, 1, 380,  1, 308, NOW(), NOW()),
(417, 2, 520,  1, 308, NOW(), NOW()),
(418, 3, 900,  1, 308, NOW(), NOW()),
(419, 4, 1800, 1, 308, NOW(), NOW());


-- ─────────────────────────────────────────────
--  A_DEPARTMENTS
--  type: 1=F&B, 2=Housekeeping, 3=Front Office, 4=HR, 5=Finance, 6=Security
-- ─────────────────────────────────────────────
INSERT INTO A_DEPARTMENTS (id, type, name, status, dept_hotel_id, resort_hotel_id, create_ts, update_ts) VALUES
-- NY hotel departments
(501, 3, 'Front Office',    1, 101, NULL, NOW(), NOW()),
(502, 2, 'Housekeeping',    1, 101, NULL, NOW(), NOW()),
(503, 1, 'Food & Beverage', 1, 101, NULL, NOW(), NOW()),
(504, 4, 'Human Resources', 1, 101, NULL, NOW(), NOW()),
-- LA hotel departments
(505, 3, 'Front Office',    1, 102, NULL, NOW(), NOW()),
(506, 2, 'Housekeeping',    1, 102, NULL, NOW(), NOW()),
-- London hotel departments
(507, 3, 'Front Office',    1, 103, NULL, NOW(), NOW()),
(508, 1, 'Food & Beverage', 1, 103, NULL, NOW(), NOW()),
-- Singapore hotel departments
(509, 3, 'Front Office',    1, 104, NULL, NOW(), NOW()),
(510, 6, 'Security',        1, 104, NULL, NOW(), NOW()),
-- Miami resort department
(511, 2, 'Housekeeping',    1, NULL, 201, NOW(), NOW());

-- Reset GLOBAL_SEQUENCE above highest manually-inserted ID (511)
SELECT setval('GLOBAL_SEQUENCE', 600);


-- ─────────────────────────────────────────────
--  A_EMPLOYEES
--  gender: MALE / FEMALE / OTHER
--  status: 1=Active, 0=Inactive
--  designation: 1=Staff, 2=Supervisor, 3=Manager, 4=Director, 5=GM
--  grade: 1–10
-- ─────────────────────────────────────────────
INSERT INTO A_EMPLOYEES
    (id, first_name, middle_name, last_name, date_of_birth, edu_type, hire_date, last_date,
     id_type, id_no, mobile, gender, designation, status, curr_add_same_as_perm_add, grade,
     reports_to, emp_dept_id, emp_perm_add_id, emp_cur_add_id, create_ts, update_ts)
VALUES
-- GM – no manager (reports_to NULL)
(601, 'James',   NULL, 'Harrison', '1970-04-12', 3, '1995-08-01', NULL,         1, 'P1234567', '+12125550101', 'MALE',   5, 1, TRUE,  10, NULL, 504, 9,  19, NOW(), NOW()),

-- Directors reporting to GM (601)
(602, 'Sophia',  'A',  'Chen',     '1978-09-25', 3, '2002-03-15', NULL,         1, 'P2345678', '+12125550102', 'FEMALE', 4, 1, FALSE, 9,  601, 501, 10, 20, NOW(), NOW()),
(603, 'Michael', NULL, 'Torres',   '1975-11-30', 3, '2000-06-01', NULL,         1, 'P3456789', '+12125550103', 'MALE',   4, 1, TRUE,  9,  601, 502, 11, 21, NOW(), NOW()),

-- Managers reporting to directors
(604, 'Aisha',   NULL, 'Patel',    '1985-02-14', 2, '2010-01-10', NULL,         2, 'A4567890', '+12125550104', 'FEMALE', 3, 1, FALSE, 7,  602, 501, 12, 22, NOW(), NOW()),
(605, 'Liam',    'R',  'O''Brien', '1983-07-07', 2, '2008-09-20', NULL,         2, 'A5678901', '+12125550105', 'MALE',   3, 1, TRUE,  7,  603, 502, 13, 23, NOW(), NOW()),

-- Staff reporting to managers
(606, 'Priya',   NULL, 'Singh',    '1993-12-01', 1, '2018-04-05', NULL,         3, 'D6789012', '+12125550106', 'FEMALE', 1, 1, TRUE,  3,  604, 501, 14, 24, NOW(), NOW()),
(607, 'Carlos',  'J',  'Mendez',   '1990-06-18', 1, '2016-07-11', NULL,         3, 'D7890123', '+12125550107', 'MALE',   1, 1, TRUE,  3,  604, 501, 15, 25, NOW(), NOW()),
(608, 'Emily',   NULL, 'Wright',   '1995-03-22', 1, '2020-02-17', NULL,         3, 'D8901234', '+14155550108', 'FEMALE', 1, 1, FALSE, 2,  605, 502, 16, 26, NOW(), NOW()),
(609, 'Noah',    NULL, 'Kim',      '1997-08-09', 1, '2021-11-01', NULL,         3, 'D9012345', '+12125550109', 'MALE',   2, 1, TRUE,  4,  605, 503, 17, 27, NOW(), NOW()),

-- Inactive employee example
(610, 'Rachel',  NULL, 'Brown',    '1988-01-15', 2, '2012-05-01', '2023-12-31', 1, 'P0123456', '+12125550110', 'FEMALE', 2, 0, TRUE,  5,  602, 505, 18, 28, NOW(), NOW());

SELECT setval('EMP_SEQUENCE', 700);
