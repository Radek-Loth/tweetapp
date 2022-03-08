package com.tweetapp.demo.services;

import com.tweetapp.demo.models.Comment;
import com.tweetapp.demo.models.Tweet;
import com.tweetapp.demo.models.User;
import com.tweetapp.demo.repos.TweetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TweetService {

    private final TweetRepository tweetRepository;
    private final AuthService authService;

    public List<Tweet> getTweets() {
        return tweetRepository.findAll();
    }

    public Tweet addTweet(Tweet tweet, String username) {
/*        tweet.setCreated(LocalDateTime.now());
        tweet.setModified(LocalDateTime.now());
        tweet.setAuthor(authService.getUserId(username));*/


        tweet.setComment(Collections.<Comment>emptyList());
        tweet.setLikes(Collections.<User>emptyList());

        return tweetRepository.save(tweet);
    }

    public List<Tweet> getUserTweets(String id) {
        return tweetRepository.findAllByAuthor(id);
    }

    @Transactional
    public Tweet updateTweet(String postId, Tweet tweet) {
        Tweet edited = tweetRepository.findById(postId).orElseThrow();
        edited.setModified(LocalDateTime.now());
        edited.setContent(tweet.getContent());
        edited.setTitle(tweet.getTitle());
        return tweetRepository.save(edited);
    }

    public void deleteTweet(String id) {
        tweetRepository.deleteById(id);
    }

    public void likeTweet(String id, Principal principal) {
        List<User> likes = tweetRepository.findById(id).orElseThrow().getLikes();
        likes.add(authService.getUserByPrincipal(principal));
        Tweet tweet = tweetRepository.findById(id).orElseThrow();
        tweet.setLikes(likes);
        tweetRepository.save(tweet);
    }
}
