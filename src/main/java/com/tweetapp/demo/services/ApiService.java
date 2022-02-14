package com.tweetapp.demo.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {

    private static final String URL = "http://localhost:8080/";
    private RestTemplate restTemplate = new RestTemplate();

    public String getTweets(){
        return restTemplate.getForObject(URL + "tweets", String.class);
    }

}
