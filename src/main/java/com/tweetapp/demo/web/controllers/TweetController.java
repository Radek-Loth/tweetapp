package com.tweetapp.demo.web.controllers;

import com.tweetapp.demo.models.Tweet;
import com.tweetapp.demo.services.AuthService;
import com.tweetapp.demo.services.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class TweetController {

    private TweetService tweetService;
    private AuthService authService;

    @Autowired
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    @Autowired
    public void setTweetService(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @GetMapping("tweets/all")
    public List<Tweet> getTweets() {
        return tweetService.getTweets();
    }

    @GetMapping("tweets/username")
    public List<Tweet> getUserTweets(String username) {
        return tweetService.getUserTweets(authService.getUserId(username));
    }

    @PostMapping("add")
    public Tweet addTweet(@RequestBody Tweet tweet, Principal principal) {
        return tweetService.addTweet(tweet);
    }

    @DeleteMapping("delete/{id}")
    public void deleteTweet(@PathVariable String id) {
        tweetService.deleteTweet(id);
    }

    @PutMapping("like/{id}")
    public void likeTweet(@PathVariable String id, Principal principal) {
        tweetService.likeTweet(id, principal);
    }

    @PutMapping("update/{id}")
    public Tweet updateTweet(@PathVariable String id, @RequestBody Tweet tweet) {
        return tweetService.updateTweet(id, tweet);
    }

    @PostMapping("reply/{id}")
    public void replyTweet(@PathVariable("id") String parentId, @RequestBody Tweet reply) {
        tweetService.replyTweet(parentId, reply);
    }

    /*
    @GetMapping("/tweet/my")
    public List<Tweet> getMyTweets(Principal principal) {
        return tweetService.getMyTweets(authService.getUserId(principal.getName()));
    }
    */
}
