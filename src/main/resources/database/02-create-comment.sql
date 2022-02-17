--liquibase formatted sql
--changeset rloth:2

CREATE TABLE comment
(
    id        BIGINT AUTO_INCREMENT PRIMARY KEY,
    tweet_id  BIGINT NOT NULL,
    author_id BIGINT NOT NULL,
    content   VARCHAR(2000) NULL,
    created   TIMESTAMP
);

ALTER TABLE comment
    ADD CONSTRAINT comment_tweet_id
        FOREIGN KEY (tweet_id) REFERENCES tweet (id)