--liquibase formatted sql

--changeset maslov_ilya:1.0.13
--comment teacher
INSERT INTO teacher (first_name, last_name, status_id)
VALUES ('Zavyalova', 'Anasteysha', 2);
