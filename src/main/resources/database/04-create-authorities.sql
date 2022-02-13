--liquibase formatted sql
--changeset rloth:4

create table authorities
(
    id        BIGINT AUTO_INCREMENT PRIMARY KEY,
    username  varchar(50) not null,
    authority varchar(50) not null,
    constraint fk_authorities_users foreign key (username) references
        users (username),
    UNIQUE KEY username_authority (username, authority)
);