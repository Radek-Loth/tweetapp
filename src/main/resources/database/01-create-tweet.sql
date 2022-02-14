--liquibase formatted sql
--changeset rloth:1

CREATE TABLE tweet
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    author_id BIGINT NOT NULL,
    title VARCHAR(400) NOT NULL,
    content VARCHAR(2000) NULL,
    created TIMESTAMP

);