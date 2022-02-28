package com.tweetapp.demo.web.dtos;

import com.tweetapp.demo.models.validators.email.ValidEmail;
import com.tweetapp.demo.models.validators.password.PasswordMatches;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@PasswordMatches
public class UserDto {

    @NotNull
    @NotEmpty
    private String firstName;
    @NotNull
    @NotEmpty
    private String lastName;

    private Boolean isFemale;

    private LocalDate dateOfBirth;
    @NotNull
    @NotEmpty
    private String username;
    @ValidEmail
    @NotNull
    @NotEmpty
    private String email;
    @NotNull
    @NotEmpty
    private String password;
}