package com.tweetapp.demo.controllers;

import com.tweetapp.demo.config.LoginCredentials;
import com.tweetapp.demo.models.DTOs.UserDto;
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

    @PostMapping("/login")
    public void login(@RequestBody LoginCredentials credentials) {
    }

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> processRegister(@RequestBody UserDto user) {

        if (authService.usernameExist(user)) {
            return new ResponseEntity<>("{\n" + "  \"message\" : \"USERNAME_EXISTS\"\n" + "}\n", HttpStatus.BAD_REQUEST);
        } else {
            authService.register(user);
            return new ResponseEntity<>("{\n" + "  \"message\" : \"REGISTER_SUCCESS\"\n" + "}\n", HttpStatus.CREATED);
        }
    }
/*    @PostMapping(value = "/changePassword")
    public String changePassword(@RequestBody LoginCredentials credentials) {
        return authService.changePassword(credentials).toString();
    }*/

/*    @PostMapping(value = "/resetPassword")
    public String resetPassword(@RequestBody UserDto user) {
        return authService.resetPassword(user).toString();
    }*/

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Principal principal) {
        return principal.getName();
    }

    @GetMapping("/users")
    public List<String> listUsers() {
        return authService.listUsers();
    }
}
