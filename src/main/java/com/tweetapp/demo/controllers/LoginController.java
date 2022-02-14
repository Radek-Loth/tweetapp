package com.tweetapp.demo.controllers;

import com.tweetapp.demo.config.LoginCredentials;
import com.tweetapp.demo.models.DTOs.UserDto;
import com.tweetapp.demo.models.User;
import com.tweetapp.demo.services.AuthService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public void login(@RequestBody LoginCredentials credentials){
    }

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> processRegister(@RequestBody UserDto accountDto) {

        if (authService.usernameExist(accountDto)) {
            return new ResponseEntity<>("{\n" + "  \"message\" : \"USERNAME_EXISTS\"\n" + "}\n", HttpStatus.BAD_REQUEST);
        } else if (authService.usernameExist(accountDto)) {
            authService.register(accountDto);
            return new ResponseEntity<>("{\n" + "  \"message\" : \"REGISTER_SUCCESS\"\n" + "}\n", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("{\n" + "  \"message\" : \"UNKNOWN\"\n" + "}\n", HttpStatus.NOT_IMPLEMENTED);
        }
    }
}
