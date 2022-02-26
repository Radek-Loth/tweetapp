package com.tweetapp.demo.repos;

import com.tweetapp.demo.models.Tweet;
<<<<<<< Updated upstream
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
=======
import org.springframework.data.mongodb.repository.MongoRepository;
>>>>>>> Stashed changes
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends MongoRepository<Tweet, Long> {

    List<Tweet> findAllByAuthor(String id);
//    List<Tweet> findAllByAuthor_id(Long id);

<<<<<<< Updated upstream
    @Query("SELECT t FROM Tweet t WHERE t.author_id = ?1")
    List<Tweet> findAllByAuthorId(Long id);
=======
>>>>>>> Stashed changes
}