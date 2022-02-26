package com.tweetapp.demo.services;

import com.tweetapp.demo.models.Tweet;

import java.util.List;

public interface ITweetService {

    List<String> getTweets();

    Tweet addTweet(Tweet tweet, String username);

    List<String> getMyTweets(String id);
}
