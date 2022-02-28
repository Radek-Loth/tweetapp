package com.tweetapp.demo.services;

import com.tweetapp.demo.web.dtos.UserDto;
import com.tweetapp.demo.models.User;
import com.tweetapp.demo.repos.UserRepository;
import com.tweetapp.demo.web.errors.UserAlreadyExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthService {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    private UserRepository userRepository;

    private boolean usernameExist(String username) {
        return userRepository.findByUsername(username) != null;
    }

    private boolean emailExist(String email) {
        return userRepository.findByUsername(email) != null;
    }


    public User register(UserDto dto) throws UserAlreadyExistException{

        if(emailExist(dto.getEmail())){
            throw new UserAlreadyExistException("There is an account with that email address: " + dto.getEmail());
        }
        else if(usernameExist(dto.getUsername())){
            throw new UserAlreadyExistException("There is an account with that username: " + dto.getUsername());
        }

        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setIsFemale(dto.getIsFemale());
        user.setPassword("{bcrypt}" + passwordEncoder.encode(dto.getPassword()));
        user.setUsername(dto.getUsername());
        user.setEnabled(true);
        user.setDateOfBirth(dto.getDateOfBirth());
        user.setIsLoggedIn(false);

        userRepository.save(user);

        return user;
    }
/*    @Transactional
    public Integer changePassword(LoginCredentials credentials) {
        return userRepository.updatePassword(credentials.getUsername(), "{bcrypt}" + passwordEncoder.encode(credentials.getPassword()));
    }*/

    public User resetPassword(UserDto user) {
        User checkUser = userRepository.findByUsername(user.getUsername());
        if
        (       checkUser.getUsername().equals(user.getUsername()) &&
                checkUser.getFirstName().equals(user.getFirstName()) &&
                checkUser.getLastName().equals(user.getLastName()) &&
                checkUser.getDateOfBirth().equals(user.getDateOfBirth()) &&
                checkUser.getIsFemale().equals(user.getIsFemale())
        ){
            checkUser.setPassword("{bcrypt}" + passwordEncoder.encode(user.getPassword()));
            return userRepository.save(checkUser);
        }
        else return null;
    }

    public List<User> listUsers() {

        return userRepository.findAll();
    }

    public String getUserId(String username) {
        return userRepository.findByUsername(username).getId();
    }
}
