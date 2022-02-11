package com.tweetapp.demo.services;

import com.tweetapp.demo.repos.TweetRepository;
import lombok.RequiredArgsConstructor;
import models.Tweet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TweetService {

    private final TweetRepository tweetRepository;

    public List<Tweet> getTweets(){
        return tweetRepository.findAll();
    }
}
