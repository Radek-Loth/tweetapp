package com.tweetapp.demo.consoleWebClient;

import com.tweetapp.demo.config.LoginCredentials;
import com.tweetapp.demo.models.DTOs.UserDto;
import com.tweetapp.demo.models.Tweet;
import com.tweetapp.demo.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiClient {

    private static final String URL = "http://localhost:8080/";
    @Autowired
    UserRepository userRepository;
    private final RestTemplate restTemplate = new RestTemplate();
    private String token = null;
    private final HttpHeaders headers = new HttpHeaders();

    public String getTweets() {
        headers.set("Authorization", token);
        HttpEntity request = new HttpEntity(headers);
        return restTemplate.exchange(URL + "tweet", HttpMethod.GET, request, String.class).getBody();
    }

    public String getMyTweets() {
        headers.set("Authorization", token);
        HttpEntity request = new HttpEntity(headers);
        return restTemplate.exchange(URL + "tweet/my", HttpMethod.GET, request, String.class).getBody();
    }

    public String login(LoginCredentials credentials) {
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(URL + "login", credentials, String.class);
        token = String.valueOf(stringResponseEntity.getHeaders().get("Authorization")).replaceAll("\\[|\\]", "");
        return token;
    }

    public String register(UserDto user) {
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(URL + "register", user, String.class);
        return String.valueOf(stringResponseEntity.getHeaders().get("Authorization"));
    }

    public String resetPassword(LoginCredentials credentials) {
        return String.valueOf(restTemplate.postForEntity(URL + "resetPassword", credentials, String.class));
    }

    @Transactional
    public void loggedInStateChange(LoginCredentials credentials, Boolean isLoggedIn) {
        userRepository.findByUsername(credentials.getUsername()).setIsLoggedIn(isLoggedIn);
    }

    @Transactional
    public void logoutAllUsers() {
        userRepository.logoutAllUsers();
    }

    public String postTweet(Tweet tweet) {
        headers.set("Authorization", token);
        HttpEntity<Tweet> request = new HttpEntity(tweet, headers);
        return String.valueOf(restTemplate.postForEntity(URL + "tweet", request, String.class));
    }

    public String getUsers() {
        headers.set("Authorization", token);
        HttpEntity request = new HttpEntity(headers);
        return restTemplate.exchange(URL + "users", HttpMethod.GET, request, String.class).getBody();

    }
}
