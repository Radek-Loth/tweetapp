package com.tweetapp.demo.services;

import com.tweetapp.demo.models.Tweet;
import com.tweetapp.demo.repos.TweetRepository;
import com.tweetapp.demo.services.interfaces.ITweetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TweetService {

    private final TweetRepository tweetRepository;
    private final AuthService authService;

    public List<Tweet> getTweets() {
        return tweetRepository.findAll();
    }

    public Tweet addTweet(Tweet tweet, String username) {
        tweet.setCreated(LocalDateTime.now());
        tweet.setAuthor(authService.getUserId(username));
        return tweetRepository.save(tweet);
    }

    public List<Tweet> getUserTweets(String id) {
        return tweetRepository.findAllByAuthor(id);
    }

    @Transactional
    public Tweet updateTweet(String postId, Tweet tweet) {
        Tweet edited = tweetRepository.findById(postId).orElseThrow();
        edited.setEdited(LocalDateTime.now());
        edited.setContent(tweet.getContent());
        edited.setTitle(tweet.getTitle());
        return tweetRepository.save(edited);
    }
}
