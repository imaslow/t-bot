--liquibase formatted sql

--changeset maslov_ilya:1.0.5
--comment schedule
CREATE TABLE schedule (
                          schedule_id SERIAL PRIMARY KEY,
                          date_time TIMESTAMP,
                          day_of_week VARCHAR(50),
                          teacher_id BIGINT,
                          FOREIGN KEY (teacher_id) REFERENCES teacher(teacher_id)
);