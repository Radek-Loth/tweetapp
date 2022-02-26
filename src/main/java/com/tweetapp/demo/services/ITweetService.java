package com.tweetapp.demo.services;

import com.tweetapp.demo.models.Tweet;

import java.util.List;

public interface ITweetService {

    public List<String> getTweets();
    public Tweet addTweet(Tweet tweet, String username);
<<<<<<< Updated upstream
    public List<String> getMyTweets(Long id);
=======
    public List<String> getMyTweets(String id);
>>>>>>> Stashed changes
}
