package models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Tweet {
    @Id
    private Long id;
    private String title;
    private String content;
    private LocalDateTime created;
    @OneToMany
    @JoinColumn(name = "tweet_id")
    private List<Comment> comment;
}
