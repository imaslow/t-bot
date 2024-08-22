--liquibase formatted sql

--changeset maslov_ilya:1.0.18
--comment travel
CREATE TABLE travel (
                        travel_id SERIAL PRIMARY KEY,
                        phrase VARCHAR(255),
                        translate VARCHAR(255),
                        travel_identifier VARCHAR(255)
);


