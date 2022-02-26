package com.tweetapp.demo.models;

import lombok.Getter;
import lombok.Setter;
<<<<<<< Updated upstream

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "authorities")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String authority;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username", referencedColumnName = "username")
=======
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Authority {

    @Id
    private long id;
    private String authority;
>>>>>>> Stashed changes
    private User user;
}