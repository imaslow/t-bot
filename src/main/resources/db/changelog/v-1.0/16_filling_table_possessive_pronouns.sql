--liquibase formatted sql

--changeset maslov_ilya:1.0.16
--comment possessive_pronouns
INSERT INTO possessive_pronouns (pp_subject, possessive_adjectives, possessive_pronouns, translate, example)
VALUES (1, 'My', 'Mine', 'Мой', 'This place is mine'),
       (2, 'Your', 'Yours', 'Твой, ваш', 'This place is yours'),
       (3, 'His', 'His', 'Его', 'This place is his'),
       (4, 'Her', 'Hers', 'Ее', 'This place is hers'),
       (5, 'Its', 'Its', 'Его, ее (для неодушевленных)', 'This place is its'),
       (6, 'Our', 'Ours', 'Наш', 'This place is ours'),
       (7, 'Their', 'Theirs', 'Их', 'This place is theirs');