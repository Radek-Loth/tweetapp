package com.tweetapp.demo.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Document
public class Comment {

    @Id
    private long id;
    private String content;
    private LocalDateTime created;

}