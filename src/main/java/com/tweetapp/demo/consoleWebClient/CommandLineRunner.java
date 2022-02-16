package com.tweetapp.demo.consoleWebClient;

import com.tweetapp.demo.config.LoginCredentials;
import com.tweetapp.demo.models.DTOs.TweetDto;
import com.tweetapp.demo.models.DTOs.UserDto;
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
    private LoginCredentials loginCredentials = new LoginCredentials();
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void run(String... args) throws Exception {

        System.out.println(apiClient.getTweets());

        while(true){

            if(isLoggedIn == false){
                System.out.println(" 1. Register \n 2. Login \n 3. Forgot Password \n");

                selectedOption = reader.readLine();

                switch (selectedOption){
                    case "1":
                        System.out.println("Login:");
                        loginCredentials.setUsername(reader.readLine());
                        System.out.println("Password:");
                        loginCredentials.setPassword(reader.readLine());
                        apiClient.register(loginCredentials);

                        break;
                    case "2":
                        System.out.println("Login:");
                        loginCredentials.setUsername(reader.readLine());
                        System.out.println("Password:");
                        loginCredentials.setPassword(reader.readLine());

                        String token = apiClient.login(loginCredentials);
                        isLoggedIn = true;
                        System.out.println("Logged in");

                        break;
                    case "3":
                        System.out.println("Login:");
                        loginCredentials.setUsername(reader.readLine());
                        System.out.println("New password:");
                        loginCredentials.setPassword(reader.readLine());
                        apiClient.resetPassword(loginCredentials);
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
