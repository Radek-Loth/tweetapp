package com.tweetapp.demo.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
@Document(collection = "comment")
public class Comment {

    @Id
    private long id;
    @Field("content")
    private String content;
    @Field("created")
    private LocalDateTime created;

}