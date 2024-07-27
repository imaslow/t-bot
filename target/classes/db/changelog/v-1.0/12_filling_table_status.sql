--liquibase formatted sql

--changeset maslov_ilya:1.0.12
--comment status
INSERT INTO status (status)
VALUES ('Student'),
       ('Teacher');