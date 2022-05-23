INSERT INTO u_address
(id, address1, address2, city, country, create_ts, pin_code, state, "type", update_ts)
VALUES(1, 'Express Towers', 'Nariman Point', 'Mumbai', 'India', now(), '400021', 'Maharashtra', 1, now());

INSERT INTO a_parent_companies
(id, founded, isin, industry, "name", "type", parent_address_id)
VALUES(1, '1989-03-25', 'INE053A01029', 'Hospitality', 'The Indian Hotels Company Limited', 1, 1);

INSERT INTO u_address
(id, address1, address2, city, country, create_ts, pin_code, state, "type", update_ts)
VALUES(2, 'Express Towers', 'Nariman Point', 'Mumbai', 'India', now(), '400021', 'Maharashtra', 1, now());

INSERT INTO a_groups
(id, create_ts, "name", status, update_ts, group_address_id, group_parent_id)
VALUES(2, now(), 'Taj Hotels', 1, now(), 2, 1);

