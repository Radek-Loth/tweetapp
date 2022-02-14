package com.tweetapp.demo.models.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TweetDto {
    private long id;
    private String title;
    private String content;
    private LocalDateTime created;
}
