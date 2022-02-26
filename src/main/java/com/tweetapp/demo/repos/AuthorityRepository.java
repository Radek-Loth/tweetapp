package com.tweetapp.demo.repos;

import com.tweetapp.demo.models.Authority;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorityRepository extends MongoRepository<Authority, Long> {

}