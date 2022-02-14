package com.tweetapp.demo.consoleWebClient;

import com.tweetapp.demo.models.DTOs.TweetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
@RequiredArgsConstructor
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

    private final ApiClient apiClient;
    private boolean isLoggedIn = false;
    private String token = null;
    private String selectedOption = null;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void run(String... args) throws Exception {

        System.out.println(apiClient.getTweets());
        System.out.println(apiClient.login());

        while(true){

            if(isLoggedIn == false){
                System.out.println(" 1. Register \n 2. Login \n 3. Forgot Password \n");

                selectedOption = reader.readLine();

                switch (selectedOption){
                    case "1":
                        System.out.println("register");
                        break;
                    case "2":
                        System.out.println("login");
                        isLoggedIn = true;
                        break;
                    case "3":
                        System.out.println("forgot password");
                        break;
                }
            }
            else if(isLoggedIn == true){
                System.out.println(" 1. Post a tweet \n 2. View my tweets \n 3. View all tweets \n 4. View all users \n 5. Reset password \n 6. Logout \n");

                selectedOption = reader.readLine();

                switch (selectedOption){
                    case "1":
                        System.out.println("Post a tweet");
                        break;
                    case "2":
                        System.out.println("View my tweets");
                        break;
                    case "3":
                        System.out.println("View all tweets");
                        System.out.println(apiClient.getTweets());
                        break;
                    case "4":
                        System.out.println("View all users");
                        break;
                    case "5":
                        System.out.println("Reset password");
                        break;
                    case "6":
                        System.out.println("Logout");
                        isLoggedIn = false;
                        break;
                }
            }
        }
    }
}
