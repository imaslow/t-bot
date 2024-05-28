--liquibase formatted sql

--changeset maslov_ilya:1.0.5
--comment student
INSERT INTO student (first_name, last_name, email,  teacher_id, group_name_id, chat_id)
VALUES ('Maslov', 'Ilya', 'ilya.maslov.93@list.ru', 1, 1, 800063551),
       ('', 'Nicolas', 'ilya.maslov.93@list.ru', 1, 1, null),
       ('', 'Uriy', 'ilya.maslov.93@list.ru', 1, 1, null),
       ('', 'Ruslan', 'ilya.maslov.93@list.ru', 1, 1, null),
       ('', 'Masha', 'ilya.maslov.93@list.ru', 1, 1, null);