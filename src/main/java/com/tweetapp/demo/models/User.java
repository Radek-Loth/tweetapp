package com.tweetapp.demo.models;

<<<<<<< Updated upstream
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(name = "is_female", nullable = false)
    private Boolean isFemale;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "username", nullable = false, unique = true, length = 100)
    private String username;

    @Column(name = "password" ,nullable = false, length = 100)
    private String password;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled;

    @Column(name = "is_logged_in", nullable = false)
    private Boolean isLoggedIn;
=======
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Document
public class User implements UserDetails {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Boolean isFemale;
    private LocalDate dateOfBirth;
    private String username;
    private String password;
    private Boolean enabled;
    private Boolean isLoggedIn;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
>>>>>>> Stashed changes
}