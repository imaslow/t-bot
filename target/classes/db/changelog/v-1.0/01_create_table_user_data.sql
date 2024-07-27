--liquibase formatted sql

--changeset maslov_ilya:1.0.1
--comment user_data
CREATE TABLE user_data (
                                chat_id BIGINT PRIMARY KEY,
                                first_name VARCHAR(255),
                                last_name VARCHAR(255),
                                user_name VARCHAR(255),
                                registered_at TIMESTAMP
);