package com.tweetapp.demo;

import com.tweetapp.demo.controllers.TweetController;
import com.tweetapp.demo.models.Tweet;
import com.tweetapp.demo.repos.TweetRepository;
import com.tweetapp.demo.services.TweetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

    private final TweetController tweetController;
    private boolean isLoggedIn = false;
    List<Tweet> tweets;

    @Override
    public void run(String... args) throws Exception {

        tweets = tweetController.getTweets();

        for(Tweet tweet: tweets){
            System.out.println(tweet.toString());
        }

        String selectedOption;

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        while(true){

            if(isLoggedIn == false){
                System.out.println(" 1. Register \n 2. Login \n 3. Forgot Password \n");
            }
            else if(isLoggedIn == false){
                System.out.println(" 1. Post a tweet \n 2. View my tweets \n 3. View all tweets \n 4. View all users \n 5. Reset password \n 6. Logout \n");
            }
            selectedOption = reader.readLine();
        }
    }
}
