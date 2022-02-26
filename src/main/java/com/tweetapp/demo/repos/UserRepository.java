package com.tweetapp.demo.repos;

import com.tweetapp.demo.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
/*
    Integer updatePassword(@Param("name") String username,
                           @Param("pass") String password);

    Integer logoutAllUsers();*/
}