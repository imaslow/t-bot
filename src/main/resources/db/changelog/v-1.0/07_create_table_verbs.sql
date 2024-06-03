--liquibase formatted sql

--changeset maslov_ilya:1.0.7
--comment verbs
CREATE TABLE verbs (
                       verbs_id SERIAL PRIMARY KEY,
                       infinitive VARCHAR(255),
                       simple_past VARCHAR(255),
                       past_participle VARCHAR(255),
                       translate VARCHAR(255)
);
