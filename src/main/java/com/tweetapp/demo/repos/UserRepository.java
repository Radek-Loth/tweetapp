package com.tweetapp.demo.repos;

import com.tweetapp.demo.models.User;
<<<<<<< Updated upstream
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
=======
import org.springframework.data.mongodb.repository.MongoRepository;
>>>>>>> Stashed changes
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
<<<<<<< Updated upstream
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username = ?1")
    User findByUsername(String username);

    @Modifying
    @Query("UPDATE User u SET u.password = :pass  WHERE u.username = :name")
    Integer updatePassword(@Param("name") String username,
                           @Param("pass") String password);

    @Modifying
    @Query("UPDATE User u SET u.isLoggedIn = false  WHERE u.isLoggedIn = true")
    Integer logoutAllUsers();
=======
public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(String username);
/*
    Integer updatePassword(@Param("name") String username,
                           @Param("pass") String password);

    Integer logoutAllUsers();*/
>>>>>>> Stashed changes
}