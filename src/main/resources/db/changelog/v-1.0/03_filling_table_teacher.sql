--liquibase formatted sql

--changeset maslov_ilya:1.0.3
--comment teacher
INSERT INTO teacher (teacher_id, first_name, last_name, status_id)
VALUES (1, 'Zavyalova', 'Anasteysha', 2);
