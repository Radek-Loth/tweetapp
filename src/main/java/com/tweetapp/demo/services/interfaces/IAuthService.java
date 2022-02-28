package com.tweetapp.demo.services.interfaces;

import com.tweetapp.demo.config.LoginCredentials;
import com.tweetapp.demo.models.DTOs.UserDto;
import com.tweetapp.demo.models.User;

import java.util.List;

public interface IAuthService {

    User register(UserDto dto);

    Integer changePassword(LoginCredentials credentials);

    List<String> listUsers();

    Long getUserId(String username);
}
