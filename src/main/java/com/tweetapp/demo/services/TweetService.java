package com.tweetapp.demo.services;

import com.tweetapp.demo.models.Tweet;
import com.tweetapp.demo.repos.TweetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TweetService implements ITweetService{

    private final TweetRepository tweetRepository;

    public List<Tweet> getTweets(){
        return tweetRepository.findAll();
    }
}
