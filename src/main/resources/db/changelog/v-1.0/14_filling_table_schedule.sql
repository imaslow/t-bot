--liquibase formatted sql

--changeset maslov_ilya:1.0.14
--comment schedule
INSERT INTO schedule (date_time, day_of_week, teacher_id)
VALUES ('2024-05-20 19:00:00', 'Monday', 1),
       ('2024-05-22 19:00:00', 'Wednesday', 1),
       ('2024-05-27 19:00:00', 'Monday', 1),
       ('2024-05-29 19:00:00', 'Wednesday', 1);