package com.tweetapp.demo.repos;

import com.tweetapp.demo.models.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}