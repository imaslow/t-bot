--liquibase formatted sql

--changeset maslov_ilya:1.0.10
--comment reflexive_pronouns
CREATE TABLE reflexive_pronouns (
                                    reflexive_pronouns_id SERIAL PRIMARY KEY,
                                    pp_subject BIGINT,
                                    reflexive_pronouns VARCHAR(255),
                                    example VARCHAR(255),
                                    FOREIGN KEY (pp_subject) REFERENCES personal_pronouns (personal_pronouns_id)
);