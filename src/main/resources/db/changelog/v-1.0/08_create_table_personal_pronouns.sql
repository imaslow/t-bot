--liquibase formatted sql

--changeset maslov_ilya:1.0.8
--comment personal_pronouns
CREATE TABLE personal_pronouns (
                                   personal_pronouns_id SERIAL PRIMARY KEY,
                                   pp_subject VARCHAR(255),
                                   pp_subject_translate VARCHAR(255),
                                   pp_addition VARCHAR(255),
                                   pp_addition_translate VARCHAR(255),
                                   example VARCHAR(255)
);