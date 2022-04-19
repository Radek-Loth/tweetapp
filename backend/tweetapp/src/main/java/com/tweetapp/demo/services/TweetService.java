package com.tweetapp.demo.services;

import com.tweetapp.demo.models.Tweet;
import com.tweetapp.demo.models.User;
import com.tweetapp.demo.repos.TweetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TweetService {

    private final TweetRepository tweetRepository;
    private final AuthService authService;

    public List<Tweet> getTweets() {
        return tweetRepository.findAll();
    }

    public Tweet addTweet(Tweet tweet) {
        tweet.setReplies(Collections.<Tweet>emptyList());
        tweet.setLikes(Collections.<User>emptyList());
        tweet.setIsReply(false);

        return tweetRepository.save(tweet);
    }

    @Transactional
    public void replyTweet(String parentId, Tweet reply) {

        reply.setReplies(Collections.<Tweet>emptyList());
        reply.setLikes(Collections.<User>emptyList());
        reply.setIsReply(true);

        Tweet edited = tweetRepository.findById(parentId).orElseThrow();
        List<Tweet> replies = edited.getReplies();
        Tweet added = tweetRepository.save(reply);
        replies.add(added);
        edited.setReplies(replies);
        tweetRepository.save(edited);
    }

    public List<Tweet> getUserTweets(String id) {
        return tweetRepository.findAllByCreatedBy(id);
    }

    @Transactional
    public Tweet updateTweet(String postId, Tweet tweet) {
        Tweet edited = tweetRepository.findById(postId).orElseThrow();
        edited.setModified(LocalDateTime.now());
        edited.setContent(tweet.getContent());
        edited.setTitle(tweet.getTitle());
        return tweetRepository.save(edited);
    }

    public void deleteTweet(String id) {
        tweetRepository.deleteById(id);
    }

    public void likeTweet(String id, Principal principal) {
        List<User> likes = tweetRepository.findById(id).orElseThrow().getLikes();
        likes.add(authService.getUserByPrincipal(principal));
        Tweet tweet = tweetRepository.findById(id).orElseThrow();
        tweet.setLikes(likes);
        tweetRepository.save(tweet);
    }
}
