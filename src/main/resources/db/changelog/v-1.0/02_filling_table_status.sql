--liquibase formatted sql

--changeset maslov_ilya:1.0.2
--comment status
INSERT INTO status (status_id, status)
VALUES (1, 'Student'),
       (2, 'Teacher');