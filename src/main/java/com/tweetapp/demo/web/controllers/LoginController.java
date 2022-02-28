package com.tweetapp.demo.web.controllers;

import com.tweetapp.demo.config.LoginCredentials;
import com.tweetapp.demo.web.dtos.UserDto;
import com.tweetapp.demo.models.User;
import com.tweetapp.demo.services.AuthService;
import com.tweetapp.demo.web.errors.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
public class LoginController {

    @Autowired
    private AuthService authService;

    @PostMapping(value = "/register")
    public ResponseEntity<String> register(@RequestBody  @Valid UserDto userDto) {
        try {
            User registered = authService.register(userDto);
            return new ResponseEntity<String>("Successfully registered user " + registered.getUsername(), HttpStatus.CREATED);
        } catch (UserAlreadyExistException uaeEx) {
            return new ResponseEntity<String>(uaeEx.toString(), HttpStatus.BAD_REQUEST);
        }
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
