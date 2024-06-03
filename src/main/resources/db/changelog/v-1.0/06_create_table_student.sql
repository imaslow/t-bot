--liquibase formatted sql

--changeset maslov_ilya:1.0.6
--comment student
CREATE TABLE student (
                         student_id SERIAL PRIMARY KEY,
                         chat_id BIGINT,
                         first_name VARCHAR(255),
                         last_name VARCHAR(255),
                         email VARCHAR(255),
                         group_name_id BIGINT,
                         teacher_id BIGINT,
                         FOREIGN KEY (group_name_id) REFERENCES group_name(group_name_id),
                         FOREIGN KEY (teacher_id) REFERENCES teacher(teacher_id)
);