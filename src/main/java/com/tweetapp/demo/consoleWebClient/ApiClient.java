package com.tweetapp.demo.consoleWebClient;

import com.tweetapp.demo.config.LoginCredentials;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiClient {

    private static final String URL = "http://localhost:8080/";
    private RestTemplate restTemplate = new RestTemplate();

    public String getTweets(){
        return restTemplate.getForObject(URL + "tweets", String.class);
    }

    public String login(){
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(URL + "login", new LoginCredentials("test", "test"), String.class);
        return String.valueOf(stringResponseEntity.getHeaders().get("Authorization"));
    }
}
