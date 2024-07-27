--liquibase formatted sql

--changeset maslov_ilya:1.0.9
--comment possessive_pronouns
CREATE TABLE possessive_pronouns (
                                     possessive_pronouns_id SERIAL PRIMARY KEY,
                                     pp_subject BIGINT,
                                     possessive_adjectives VARCHAR(255),
                                     possessive_pronouns VARCHAR(255),
                                     translate VARCHAR(255),
                                     example VARCHAR(255),
                                     FOREIGN KEY (pp_subject) REFERENCES personal_pronouns (personal_pronouns_id)
);