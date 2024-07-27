--liquibase formatted sql

--changeset maslov_ilya:1.0.15
--comment personal_pronouns
INSERT INTO personal_pronouns (pp_subject, pp_subject_translate, pp_addition, pp_addition_translate, example)
VALUES ('I', 'Я', 'Me', 'Мне', 'She’ll believe me someday'),
       ('You', 'Ты, вы', 'You', 'Тебе', 'I made this breakfast for you'),
       ('He', 'Он', 'Him', 'Ему', 'It’s not for him to decide'),
       ('She', 'Она', 'Her', 'Ей', 'They gave her some money'),
       ('It', 'Оно', 'It', 'Ему', 'My sister brought the plant and I bought a flower pot for it'),
       ('We', 'Мы', 'Us', 'Нам', 'She can’t ignore us for so long'),
       ('They', 'Они', 'Them', 'Им', 'I told them to stay at home');

