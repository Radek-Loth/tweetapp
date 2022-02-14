package com.tweetapp.demo;

import com.tweetapp.demo.controllers.LoginController;
import com.tweetapp.demo.controllers.TweetController;
import com.tweetapp.demo.models.Tweet;
import com.tweetapp.demo.services.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

    private final ApiService apiService;
    private boolean isLoggedIn = false;

    @Override
    public void run(String... args) throws Exception {

        String selectedOption;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(apiService.getTweets());

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
