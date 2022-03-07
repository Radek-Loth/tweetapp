package com.tweetapp.demo.web.dtos;

import com.tweetapp.demo.validators.email.ValidEmail;
import com.tweetapp.demo.validators.password.PasswordMatches;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @Size(min = 1, message = "email cannot be empty")
    private String email;
    @NotNull
    @NotEmpty
    private String password;

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("UserDto [firstName=")
                .append(firstName)
                .append(", lastName=")
                .append(lastName)
                .append(", email=")
                .append(email)
                .append(", isUsing2FA=");
        return builder.toString();
    }
}