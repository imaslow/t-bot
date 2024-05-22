--liquibase formatted sql

--changeset maslov_ilya:1.0.1
--comment group_name
INSERT INTO group_name (group_id, group_name)
VALUES (1, 'Elementary');
