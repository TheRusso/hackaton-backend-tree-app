INSERT INTO users (id, email, password, full_name) VALUES (1, 'kovalchuk.roman03@gmail.com', '$2a$08$/DS9cBHk4xe/RurfMYmrC.ubIi6apUJczAlyMjJIrcukUuPNQKYCa', 'Ковальчук Роман Олександрович');
INSERT INTO users (id, email, password, full_name) VALUES (2, 'podhorhyi_2002@ukr.net', '$2a$08$iTxDMNrWjSQ4WSkhqk4LjOWt5MC2PG/12HgPlmW9pJJn12IUCT4iW', 'Підгорний Ігор Миколайович');

ALTER SEQUENCE users_id_seq RESTART WITH 3;

INSERT INTO user_role (user_id, roles) VALUES (1, 1);
INSERT INTO user_role (user_id, roles) VALUES (1, 0);
INSERT INTO user_role (user_id, roles) VALUES (2, 1);
INSERT INTO user_role (user_id, roles) VALUES (2, 1);