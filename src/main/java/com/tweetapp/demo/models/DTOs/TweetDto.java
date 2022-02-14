package com.tweetapp.demo.models.DTOs;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class TweetDto {
    private long id;
    private Long userId;
    private String title;
    private String content;
    private LocalDateTime created;
}
