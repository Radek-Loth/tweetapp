package com.tweetapp.demo.controllers;

import com.tweetapp.demo.models.Tweet;
import com.tweetapp.demo.services.TweetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TweetController {

    private final TweetService tweetService;

    @GetMapping("/tweets")
    public List<Tweet> getTweets() {
       return tweetService.getTweets();
    }

}
