package com.tweetapp.demo.services;

import com.tweetapp.demo.models.Authority;
import com.tweetapp.demo.models.DTOs.UserDto;
import com.tweetapp.demo.models.User;
import com.tweetapp.demo.repos.AuthorityRepository;
import com.tweetapp.demo.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {


    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthorityRepository authorityRepository;

    public boolean usernameExist(UserDto user) {
        return userRepository.findByUsername(user.getUsername()) != null;
    }

    public User register(UserDto accountDto) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        User user = new User();
        user.setPassword("{bcrypt}" + passwordEncoder.encode(accountDto.getPassword()));
        user.setUsername(accountDto.getUsername());
        user.setEnabled(true);

        Authority authority = new Authority();
        authority.setAuthority("USER");
        authority.setUser(user);

        userRepository.save(user);
        authorityRepository.save(authority);

        return user;
    }

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    public Long getUserId(String username) {
        return userRepository.findByUsername(username).getId();
    }
}
