--liquibase formatted sql
--changeset rloth:5

INSERT INTO tweet(id, title, content, created) VALUES (1,'title 1', 'content 1', '2022-01-01T00:00:00.00');
INSERT INTO tweet(id, title, content, created) VALUES (2,'title 2', 'content 2', '2022-01-01T00:00:00.00');
INSERT INTO tweet(id, title, content, created) VALUES (3,'title 3', 'content 3', '2022-01-01T00:00:00.00');
INSERT INTO tweet(id, title, content, created) VALUES (4,'title 4', 'content 4', '2022-01-01T00:00:00.00');
INSERT INTO tweet(id, title, content, created) VALUES (5,'title 5', 'content 5', '2022-01-01T00:00:00.00');

INSERT INTO comment(id, tweet_id, content, created) VALUES (1,'1', 'comment 1', '2022-01-01T01:00:00.00');
INSERT INTO comment(id, tweet_id, content, created) VALUES (2,'1', 'comment 2', '2022-01-01T02:00:00.00');
INSERT INTO comment(id, tweet_id, content, created) VALUES (3,'1', 'comment 3', '2022-01-01T03:00:00.00');

INSERT INTO comment(id, tweet_id, content, created) VALUES (4,'2', 'comment 1', '2022-01-01T01:00:00.00');
INSERT INTO comment(id, tweet_id, content, created) VALUES (5,'2', 'comment 2', '2022-01-01T02:00:00.00');
INSERT INTO comment(id, tweet_id, content, created) VALUES (6,'2', 'comment 3', '2022-01-01T03:00:00.00');

INSERT INTO comment(id, tweet_id, content, created) VALUES (7,'3', 'comment 1', '2022-01-01T01:00:00.00');
INSERT INTO comment(id, tweet_id, content, created) VALUES (8,'3', 'comment 2', '2022-01-01T02:00:00.00');
INSERT INTO comment(id, tweet_id, content, created) VALUES (9,'3', 'comment 3', '2022-01-01T03:00:00.00');

INSERT INTO comment(id, tweet_id, content, created) VALUES (10,'4', 'comment 1', '2022-01-01T01:00:00.00');
INSERT INTO comment(id, tweet_id, content, created) VALUES (11,'4', 'comment 2', '2022-01-01T02:00:00.00');
INSERT INTO comment(id, tweet_id, content, created) VALUES (12,'4', 'comment 3', '2022-01-01T03:00:00.00');

INSERT INTO comment(id, tweet_id, content, created) VALUES (13,'5', 'comment 1', '2022-01-01T01:00:00.00');
INSERT INTO comment(id, tweet_id, content, created) VALUES (14,'5', 'comment 2', '2022-01-01T02:00:00.00');
INSERT INTO comment(id, tweet_id, content, created) VALUES (15,'5', 'comment 3', '2022-01-01T03:00:00.00');

INSERT INTO users (id, email, first_name, last_name, username, password, enabled) VALUES (1, 'test@test.com', 'Name', 'Lastname', 'test', '{bcrypt}$2a$10$upzXFsFUOClFRR69OMKF8eajGMRs0vhcSHqvNDKy9yfW45w7o9z6O', true);
INSERT INTO authorities (username, authority) VALUES ('test', 'USER');