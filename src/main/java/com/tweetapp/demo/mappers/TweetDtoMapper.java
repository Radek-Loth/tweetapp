package com.tweetapp.demo.mappers;

import com.tweetapp.demo.models.Tweet;
import com.tweetapp.demo.web.dtos.TweetDto;

import java.util.List;
import java.util.stream.Collectors;

public class TweetDtoMapper {

    private TweetDtoMapper() {
    }

    public static List<TweetDto> mapToTweetDto(List<Tweet> tweets) {
        return tweets.stream()
                .map(tweet -> mapToActivityDto(tweet))
                .collect(Collectors.toList());
    }

    public static TweetDto mapToActivityDto(Tweet tweet) {
        return TweetDto.builder()
                .id(tweet.getId())
                .title(tweet.getTitle())
                .created(tweet.getCreated())
                .build();
    }
}
