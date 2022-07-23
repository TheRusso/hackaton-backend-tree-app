INSERT INTO tree (id, register_number, x, y, radius, birth_date, type_id, state, photo_url) VALUES (1, '0000000001', 10, 10, 5, to_date('10-07-2022', 'DD-MM-YYYY'), 1, 2, NULL);
INSERT INTO tree (id, register_number, x, y, radius, birth_date, type_id, state, photo_url) VALUES (2, '0000000002', 30, 40, 4, to_date('11-07-2022', 'DD-MM-YYYY'), 2, 1, NULL);
INSERT INTO tree (id, register_number, x, y, radius, birth_date, type_id, state, photo_url) VALUES (3, '0000000003', -30, 50, 7, to_date('11-07-2022', 'DD-MM-YYYY'), 3, 0, NULL);
INSERT INTO tree (id, register_number, x, y, radius, birth_date, type_id, state, photo_url) VALUES (4, '0000000004', 50, -40, 4, to_date('12-07-2022', 'DD-MM-YYYY'), 4, 1, NULL);
INSERT INTO tree (id, register_number, x, y, radius, birth_date, type_id, state, photo_url) VALUES (5, '0000000005', 30, 40, 6, to_date('12-07-2022', 'DD-MM-YYYY'), 5, 2, NULL);
INSERT INTO tree (id, register_number, x, y, radius, birth_date, type_id, state, photo_url) VALUES (6, '0000000006', 49.233083, 28.468217, 6, to_date('12-07-2022', 'DD-MM-YYYY'), 5, 2, NULL);

ALTER SEQUENCE tree_id_seq RESTART WITH 7;
