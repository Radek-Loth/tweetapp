--liquibase formatted sql
--changeset rloth:3

create table users
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    email      varchar(45)  not null,
    first_name varchar(20),
    last_name  varchar(20),
    username   varchar(50)  not null UNIQUE,
    password   varchar(100) not null,
    enabled    boolean      not null
);