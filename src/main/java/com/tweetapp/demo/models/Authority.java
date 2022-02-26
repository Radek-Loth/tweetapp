package com.tweetapp.demo.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Authority {

    @Id
    private long id;
    private String authority;
    private User user;
}