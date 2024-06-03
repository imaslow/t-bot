--liquibase formatted sql

--changeset maslov_ilya:1.0.11
--comment group_name
INSERT INTO group_name (group_name)
VALUES ('Elementary');
