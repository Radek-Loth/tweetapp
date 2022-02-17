package com.tweetapp.demo.consoleWebClient;

import com.tweetapp.demo.config.LoginCredentials;
import com.tweetapp.demo.models.DTOs.UserDto;
import com.tweetapp.demo.models.Tweet;
import lombok.RequiredArgsConstructor;
import org.apache.commons.validator.GenericValidator;
import org.apache.commons.validator.routines.DateValidator;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

@Component
@RequiredArgsConstructor
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

    private final ApiClient apiClient;
    private boolean isLoggedIn = false;
    private String selectedOption = null;
    private final LoginCredentials loginCredentials = new LoginCredentials();
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void run(String... args) throws Exception {
        apiClient.logoutAllUsers();

        while (true) {

            if (isLoggedIn == false) {
                System.out.println(" 1. Register \n 2. Login \n 3. Forgot Password \n");

                selectedOption = reader.readLine();

                switch (selectedOption) {
                    case "1":
                        UserDto dto = new UserDto();
                        do {
                            System.out.println("Email:\n");
                            dto.setUsername(reader.readLine());
                        } while (!EmailValidator.getInstance().isValid(dto.getUsername()));
                        do{
                            System.out.println("Password:\n");
                            dto.setPassword(reader.readLine());
                        }while (dto.getPassword().length() > 3);
                        do{
                            System.out.println("First name:\n");
                            dto.setFirstName(reader.readLine());
                        }while (dto.getFirstName().length() > 3);
                        do{
                            System.out.println("Last name:\n");
                            dto.setLastName(reader.readLine());
                        }while (dto.getLastName().length() > 3);
                        String date = null;
                        do{
                            System.out.println("Birth date: (yyyy-MM-dd)\n");
                            date = reader.readLine();
                        }while(!GenericValidator.isDate(date, "yyyy-MM-dd", true));
                        dto.setDateOfBirth(LocalDate.parse(date));

                        String gender = null;
                        do{
                            System.out.println("Gender: (female or male)\n");
                            gender = reader.readLine();
                            if(gender.equals("female")){
                                dto.setIsFemale(true);
                            }
                            else if(gender.equals("male")){
                                dto.setIsFemale(false);
                            }
                            else{
                                System.out.println("Probably a typo, try again.\n");
                            }
                        }while(!(gender.equals("female") || gender.equals("male")));

                        try {
                            apiClient.register(dto);
                        } catch (Exception e) {
                            System.out.println("There is a problem with registration.\n");
                        }
                        break;
                    case "2":
                        do {
                            System.out.println("Email:");
                            loginCredentials.setUsername(reader.readLine());
                        } while (!EmailValidator.getInstance().isValid(loginCredentials.getUsername()));
                        System.out.println("Password:");
                        loginCredentials.setPassword(reader.readLine());

                        try {
                            apiClient.login(loginCredentials);
                        } catch (Exception e) {
                            System.out.println("There is a problem with login.\n");
                            break;
                        }
                        isLoggedIn = true;
                        apiClient.loggedInStateChange(loginCredentials, isLoggedIn);
                        System.out.println("Logged in\n");

                        break;
                    case "3":
                        System.out.println("Email:\n");
                        loginCredentials.setUsername(reader.readLine());
                        System.out.println("New password:\n");
                        loginCredentials.setPassword(reader.readLine());
                        apiClient.resetPassword(loginCredentials);
                        break;
                }
            } else if (isLoggedIn == true) {
                System.out.println(" 1. Post a tweet \n 2. View my tweets \n 3. View all tweets \n 4. View all users \n 5. Reset password \n 6. Logout \n");

                selectedOption = reader.readLine();

                switch (selectedOption) {
                    case "1":
                        Tweet tweet = new Tweet();
                        System.out.println("Title:\n");
                        tweet.setTitle(reader.readLine());
                        System.out.println("Content:\n");
                        tweet.setContent(reader.readLine());
                        try {
                            apiClient.postTweet(tweet);
                        } catch (Exception e) {
                            System.out.println("Something went wrong\n");
                        }
                        break;
                    case "2":
                        try {
                            System.out.println(apiClient.getMyTweets());
                        } catch (Exception e) {
                            System.out.println("There is a problem with fetching tweets.\n");
                        }
                        break;
                    case "3":
                        try {
                            System.out.println(apiClient.getTweets());
                        } catch (Exception e) {
                            System.out.println("There is a problem with fetching tweets.\n");
                        }
                        break;
                    case "4":
                        try {
                            System.out.println(apiClient.getUsers());
                        } catch (Exception e) {
                            System.out.println("There is a problem with fetching users.\n");
                        }
                        break;
                    case "5":
                        System.out.println("Email:\n");
                        do {
                            loginCredentials.setUsername(reader.readLine());
                        } while (!EmailValidator.getInstance().isValid(loginCredentials.getUsername()));
                        System.out.println("New password:\n");
                        loginCredentials.setPassword(reader.readLine());
                        try {
                            apiClient.resetPassword(loginCredentials);
                        } catch (Exception e) {
                            System.out.println("Something went wrong.\n");
                        }
                        break;
                    case "6":
                        System.out.println("Logout\n");
                        isLoggedIn = false;
                        try {
                            apiClient.loggedInStateChange(loginCredentials, isLoggedIn);
                        } catch (Exception e) {
                            System.out.println("Something went wrong.\n");
                        }
                        break;
                }
            }
        }
    }
}
