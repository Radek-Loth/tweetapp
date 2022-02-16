package com.tweetapp.demo.repos;

import com.tweetapp.demo.models.Tweet;
import com.tweetapp.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {

    @Query("SELECT t FROM Tweet t WHERE t.author_id = ?1")
    List<Tweet> findAllByAuthorId(Long id);
}