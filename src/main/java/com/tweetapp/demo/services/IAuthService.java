package com.tweetapp.demo.services;

import com.tweetapp.demo.config.LoginCredentials;
import com.tweetapp.demo.models.DTOs.UserDto;
import com.tweetapp.demo.models.User;

import java.util.List;

public interface IAuthService {

    public User register(UserDto dto);
    public Integer changePassword(LoginCredentials credentials);
    public List<String> listUsers();
    public Long getUserId(String username);
}
