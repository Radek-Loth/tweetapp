--liquibase formatted sql
--changeset rloth:3

create table users
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name    varchar (100) not null,
    last_name     varchar (100),
    is_female      boolean not null,
    date_of_birth TIMESTAMP,
    username      varchar(100) not null UNIQUE,
    password      varchar(100) not null,
    enabled       boolean      not null,
    is_logged_in  boolean      not null
);