package com.tweetapp.demo.services;

import com.tweetapp.demo.config.LoginCredentials;
import com.tweetapp.demo.models.Authority;
import com.tweetapp.demo.models.DTOs.UserDto;
import com.tweetapp.demo.models.User;
import com.tweetapp.demo.repos.AuthorityRepository;
import com.tweetapp.demo.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthorityRepository authorityRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean usernameExist(LoginCredentials credentials) {
        return userRepository.findByUsername(credentials.getUsername()) != null;
    }

    public User register(LoginCredentials credentials) {

        User user = new User();
        user.setPassword("{bcrypt}" + passwordEncoder.encode(credentials.getPassword()));
        user.setUsername(credentials.getUsername());
        user.setEnabled(true);

        Authority authority = new Authority();
        authority.setAuthority("USER");
        authority.setUser(user);

        userRepository.save(user);
        authorityRepository.save(authority);

        return user;
    }

    @Transactional
    public Integer resetPassword(LoginCredentials credentials){
        return userRepository.updatePassword(credentials.getUsername(), "{bcrypt}" + passwordEncoder.encode(credentials.getPassword()));
    }

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    public Long getUserId(String username) {
        return userRepository.findByUsername(username).getId();
    }
}
