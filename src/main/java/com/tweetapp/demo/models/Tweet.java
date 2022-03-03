package com.tweetapp.demo.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "tweet")
public class Tweet {

    @Id
    private String id;
    @Field("author")
    private String author;
    @Field("title")
    private String title;
    @Field("content")
    private String content;
    @Field("created")
    private LocalDateTime created;
    @Field("edited")
    private LocalDateTime edited;
    @Field("comment")
    private List<Comment> comment;
}
