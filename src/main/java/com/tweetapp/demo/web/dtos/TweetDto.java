package com.tweetapp.demo.web.dtos;

import com.tweetapp.demo.models.Tweet;
import com.tweetapp.demo.models.User;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class TweetDto {
    private String id;
    private String createdBy;
    @NotNull
    @NotEmpty
    private String title;
    @NotNull
    @Size(min = 1, max = 144, message = "wrong size")
    private String content;
    private LocalDateTime created;
    private LocalDateTime modified;
    private List<User> likes;
    private List<Tweet> replies;
}
