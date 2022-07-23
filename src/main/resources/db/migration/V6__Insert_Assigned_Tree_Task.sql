INSERT INTO assigned_tree_task (id, task_type_id, tree_id, status, end_date) VALUES (1, 1, 1, 0, NULL);
INSERT INTO assigned_tree_task (id, task_type_id, tree_id, status, end_date) VALUES (2, 1, 2, 0, NULL);
INSERT INTO assigned_tree_task (id, task_type_id, tree_id, status, end_date) VALUES (3, 1, 3, 0, NULL);
INSERT INTO assigned_tree_task (id, task_type_id, tree_id, status, end_date) VALUES (4, 2, 4, 0, NULL);
INSERT INTO assigned_tree_task (id, task_type_id, tree_id, status, end_date) VALUES (5, 4, 5, 0, NULL);
INSERT INTO assigned_tree_task (id, task_type_id, tree_id, status, end_date) VALUES (6, 3, 1, 0, NULL);
INSERT INTO assigned_tree_task (id, task_type_id, tree_id, status, end_date) VALUES (7, 3, 2, 0, NULL);
INSERT INTO assigned_tree_task (id, task_type_id, tree_id, status, end_date) VALUES (8, 3, 3, 0, NULL);
INSERT INTO assigned_tree_task (id, task_type_id, tree_id, status, end_date) VALUES (9, 1, 4, 0, NULL);
INSERT INTO assigned_tree_task (id, task_type_id, tree_id, status, end_date) VALUES (10, 1, 1, 0, NULL);

ALTER SEQUENCE assigned_tree_task_id_seq RESTART WITH 11;