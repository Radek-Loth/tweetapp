package com.tweetapp.demo.web.controllers;

import com.tweetapp.demo.config.LoginCredentials;
import com.tweetapp.demo.models.User;
import com.tweetapp.demo.services.AuthService;
import com.tweetapp.demo.web.dtos.UserDto;
import com.tweetapp.demo.web.errors.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class LoginController {

    private AuthService authService;

    @Autowired
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<String> register(@RequestBody @Valid UserDto userDto) {
        try {
            User registered = authService.register(userDto);
            return new ResponseEntity<String>("Successfully registered user " + registered.getUsername(), HttpStatus.CREATED);
        } catch (UserAlreadyExistException uaeEx) {
            return new ResponseEntity<String>(uaeEx.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("login")
    public void login(@RequestBody LoginCredentials credentials) {
    }

    @PostMapping(value = "forgot")
    public User resetPassword(@RequestBody UserDto user) {
        return authService.resetPassword(user);
    }

/*    @PostMapping(value = "/changePassword")
    public String changePassword(@RequestBody LoginCredentials credentials) {
        return authService.changePassword(credentials).toString();
    }*/

    @GetMapping(value = "user/search/username")
    public List<User> searchByUsername(@RequestParam String username) {
        return authService.searchByUsername(username);
    }

    @GetMapping("users/all")
    public List<User> listUsers() {
        return authService.listUsers();
    }
}
