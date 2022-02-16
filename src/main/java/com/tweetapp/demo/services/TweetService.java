package com.tweetapp.demo.services;

import com.tweetapp.demo.models.Tweet;
import com.tweetapp.demo.repos.TweetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TweetService implements ITweetService{

    private final TweetRepository tweetRepository;
    private final AuthService authService;

    public List<Tweet> getTweets(){
        return tweetRepository.findAll();
    }

    public Tweet addTweet(Tweet tweet, String username) {
        tweet.setCreated(LocalDateTime.now());
        tweet.setAuthor_id(authService.getUserId(username));
        return tweetRepository.save(tweet);
    }

    public List<Tweet> getMyTweets(Long id) {
        return tweetRepository.findAllByAuthorId(id);
    }
}
