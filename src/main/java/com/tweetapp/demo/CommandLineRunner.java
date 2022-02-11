package com.tweetapp.demo;

import com.tweetapp.demo.models.Tweet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        boolean isLoggedIn = false;
        String selectedOption;

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        /*
        for(Tweet data : tweets){
            System.out.println(data.toString());
        }
        */

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
