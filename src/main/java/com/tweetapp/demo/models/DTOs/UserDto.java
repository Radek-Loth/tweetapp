package com.tweetapp.demo.models.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private String firstName;
    private String lastName;
    private Boolean isFemale;
    private LocalDate dateOfBirth;
    private String username;
    private String password;
}