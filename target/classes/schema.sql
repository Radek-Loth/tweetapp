CREATE TABLE tweet
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(400) NOT NULL,
    content VARCHAR(2000) NULL,
    created TIMESTAMP

);

CREATE TABLE comment
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    tweet_id BIGINT NOT NULL,
    content VARCHAR(2000) NULL,
    created TIMESTAMP
);

ALTER TABLE comment
    ADD CONSTRAINT comment_tweet_id
    FOREIGN KEY(tweet_id) REFERENCES tweet(id)