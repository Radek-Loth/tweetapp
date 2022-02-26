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
<<<<<<< Updated upstream:src/main/java/com/tweetapp/demo/models/Tweet.java
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long author_id;
    private String title;
    private String content;
    private LocalDateTime created;

    @OneToMany
    @JoinColumn(name = "tweetId", updatable = false, insertable = false)
=======
    private long id;

    private String author;
    private String title;
    private String content;
    private LocalDateTime created;
>>>>>>> Stashed changes:src/main/java/models/Tweet.java
    private List<Comment> comment;
}
