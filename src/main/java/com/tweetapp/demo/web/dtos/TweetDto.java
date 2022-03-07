package com.tweetapp.demo.web.dtos;

import com.tweetapp.demo.models.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class TweetDto {
    private String id;
    private Long userId;
    private String title;
    private String content;
    private List<User> likes;
    private LocalDateTime created;
    private LocalDateTime edited;
}
