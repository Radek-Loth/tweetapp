package com.tweetapp.demo.models;

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
}