package com.tweetapp.demo.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Document
public class Tweet {

    @Id
    private long id;
    private String author;
    private String title;
    private String content;
    private LocalDateTime created;
    private List<Comment> comment;
}
