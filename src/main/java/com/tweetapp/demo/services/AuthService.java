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

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthorityRepository authorityRepository;

    public boolean usernameExist(UserDto dto) {
        return userRepository.findByUsername(dto.getUsername()) != null;
    }

    public User register(UserDto dto) {

        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setIsFemale(dto.getIsFemale());
        user.setPassword("{bcrypt}" + passwordEncoder.encode(dto.getPassword()));
        user.setUsername(dto.getUsername());
        user.setEnabled(true);
        user.setDateOfBirth(dto.getDateOfBirth());
        user.setIsLoggedIn(false);

        Authority authority = new Authority();
        authority.setAuthority("USER");
        authority.setUser(user);

        userRepository.save(user);
        authorityRepository.save(authority);

        return user;
    }
/*    @Transactional
    public Integer changePassword(LoginCredentials credentials) {
        return userRepository.updatePassword(credentials.getUsername(), "{bcrypt}" + passwordEncoder.encode(credentials.getPassword()));
    }*/

/*    @Transactional
    public Integer resetPassword(UserDto user) {
        User checkUser = userRepository.findByUsername(user.getUsername());
        if
        (       checkUser.getUsername().equals(user.getUsername()) &&
                checkUser.getFirstName().equals(user.getFirstName()) &&
                checkUser.getLastName().equals(user.getLastName()) &&
                checkUser.getDateOfBirth().equals(user.getDateOfBirth()) &&
                checkUser.getIsFemale().equals(user.getIsFemale())
        ){
            return userRepository.updatePassword(user.getUsername(), "{bcrypt}" + passwordEncoder.encode(user.getPassword()));
        }
        else return 0;
    }*/


    public List<String> listUsers() {

        return userRepository.findAll()
                .stream()
                .map(user -> user.getUsername())
                .toList();
    }

    public String getUserId(String username) {
        return userRepository.findByUsername(username).getId();
    }
}
