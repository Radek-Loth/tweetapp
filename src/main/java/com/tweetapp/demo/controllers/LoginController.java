package com.tweetapp.demo.controllers;

import com.tweetapp.demo.config.LoginCredentials;
import com.tweetapp.demo.models.DTOs.UserDto;
import com.tweetapp.demo.models.User;
import com.tweetapp.demo.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class LoginController {

    @Autowired
    private AuthService authService;

    @PostMapping(value = "/register")
    public User processRegister(@RequestBody UserDto user) {
        return authService.register(user);
    }

    @PostMapping("/login")
    public void login(@RequestBody LoginCredentials credentials) {
    }

    @PostMapping(value = "/forgot")
    public String resetPassword(@RequestBody UserDto user) {
        return authService.resetPassword(user).toString();
    }

/*    @PostMapping(value = "/changePassword")
    public String changePassword(@RequestBody LoginCredentials credentials) {
        return authService.changePassword(credentials).toString();
    }*/

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Principal principal) {
        return principal.getName();
    }

    @GetMapping("/users")
    public List<User> listUsers() {
        return authService.listUsers();
    }
}
