--liquibase formatted sql

--changeset maslov_ilya:1.0.9
--comment reflexive_pronouns
INSERT INTO reflexive_pronouns (pp_subject, reflexive_pronouns, example)
VALUES (1, 'Myself', 'I rarely make the bed by myself'),
       (2, 'Yourself', 'Where do you see yourself five years from now?'),
       (3, 'Himself', 'He stopped and saw himself reflecting in the mirror'),
       (4, 'Herself', 'She found herself through music'),
       (5, 'Itself', 'The cat sat down and began to wash itself'),
       (6, 'Ourselves', 'It''s not the time to blame ourselves'),
       (7, 'Themselves', 'They did not behave themselves well');