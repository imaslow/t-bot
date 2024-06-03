--liquibase formatted sql

--changeset maslov_ilya:1.0.4
--comment teacher
CREATE TABLE teacher (
                         teacher_id SERIAL PRIMARY KEY,
                         first_name VARCHAR(255),
                         last_name VARCHAR(255),
                         status_id BIGINT,
                         FOREIGN KEY (status_id) REFERENCES status(status_id)
);