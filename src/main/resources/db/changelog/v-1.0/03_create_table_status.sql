--liquibase formatted sql

--changeset maslov_ilya:1.0.3
--comment status
CREATE TABLE status (
                        status_id SERIAL PRIMARY KEY,
                        status VARCHAR(255)
);