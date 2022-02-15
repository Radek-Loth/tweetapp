package com.tweetapp.demo.consoleWebClient;

import com.tweetapp.demo.config.LoginCredentials;
import com.tweetapp.demo.models.DTOs.UserDto;
import org.springframework.http.HttpStatus;
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

    public String login(LoginCredentials credentials){
        try{
            ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(URL + "login", credentials, String.class);
            return String.valueOf(stringResponseEntity.getHeaders().get("Authorization"));
        }catch (IllegalStateException e){
            System.out.println(e);
            return null;
        }
    }

    public String register(LoginCredentials credentials){
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(URL + "register", credentials, String.class);
        return String.valueOf(stringResponseEntity.getHeaders().get("Authorization"));
    }

    public String resetPassword(LoginCredentials credentials){
       return String.valueOf(restTemplate.postForEntity(URL + "resetPassword", credentials, String.class));
    }
}
