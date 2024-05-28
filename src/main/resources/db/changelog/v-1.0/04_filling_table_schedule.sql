--liquibase formatted sql

--changeset maslov_ilya:1.0.4
--comment schedule
INSERT INTO schedule (schedule_id, date_time, day_of_week, teacher_id)
VALUES (1, '2024-05-20 19:00:00', 'Monday', 1),
       (2, '2024-05-22 19:00:00', 'Wednesday', 1),
       (3, '2024-05-27 19:00:00', 'Monday', 1),
       (4, '2024-05-29 19:00:00', 'Wednesday', 1);