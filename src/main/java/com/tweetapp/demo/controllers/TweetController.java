package com.tweetapp.demo.controllers;

import com.tweetapp.demo.models.Tweet;
import com.tweetapp.demo.services.AuthService;
import com.tweetapp.demo.services.TweetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TweetController {

    private final TweetService tweetService;
    private final AuthService authService;

    @GetMapping("/tweet")
    public List<String> getTweets() {
        return tweetService.getTweets();
    }

    @GetMapping("/tweet/my")
    public List<String> getMyTweets(Principal principal) {
        return tweetService.getMyTweets(authService.getUserId(principal.getName()));
    }

    @PostMapping("/tweet")
    public Tweet addTweet(@RequestBody Tweet tweet, Principal principal) {
        return tweetService.addTweet(tweet, principal.getName());
    }
}
