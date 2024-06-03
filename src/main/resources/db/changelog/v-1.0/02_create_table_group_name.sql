--liquibase formatted sql

--changeset maslov_ilya:1.0.2
--comment group_name
CREATE TABLE group_name (
                           group_name_id SERIAL PRIMARY KEY,
                           group_name VARCHAR(255)
);