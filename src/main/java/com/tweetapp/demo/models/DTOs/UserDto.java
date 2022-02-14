package com.tweetapp.demo.models.DTOs;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDto {

    private String password;
    private String username;
}