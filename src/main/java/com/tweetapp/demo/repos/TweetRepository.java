package com.tweetapp.demo.repos;

import com.tweetapp.demo.models.Tweet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends MongoRepository<Tweet, Long> {
    List<Tweet> findAllByAuthor(String id);
}