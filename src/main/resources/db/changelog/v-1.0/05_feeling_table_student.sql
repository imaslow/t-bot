--liquibase formatted sql

--changeset maslov_ilya:1.0.5
--comment student
INSERT INTO student (student_id, first_name, last_name, teacher_id, group_name_id, chat_id)
VALUES (1, 'Maslov', 'Ilya', 1, 1, 800063551),
       (2, '', 'Nicolas', 1, 1, null),
       (3, '', 'Uriy', 1, 1, null),
       (4, '', 'Ruslan', 1, 1, null),
       (5, '', 'Masha', 1, 1, null);