package com.tweetapp.demo.repos;

import com.tweetapp.demo.models.Authority;
<<<<<<< Updated upstream
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
=======
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorityRepository extends MongoRepository<Authority, Long> {
>>>>>>> Stashed changes

}