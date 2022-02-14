--liquibase formatted sql
--changeset rloth:3

create table users
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    username      varchar(45)  not null UNIQUE,
    password   varchar(100) not null,
    enabled    boolean      not null
);