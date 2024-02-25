package dsa.medium.twitter;

import java.util.HashSet;
import java.util.Set;

public class User {
    private int userId;
    private Set<Integer> followed;
    private Tweet startingTweet;

    public int getUserId() {
        return userId;
    }

    public Set<Integer> getFollowed() {
        return followed;
    }

    public Tweet getStartingTweet() {
        return startingTweet;
    }

    public User(int userId) {
        this.userId = userId;
        followed = new HashSet<>();
        follow(userId);
        startingTweet = null;
    }

    public void follow(int userId) {
        followed.add(userId);
    }

    public void unFollow(int userId) {
        // You cannot unfollow yourself
        if (this.userId != userId) {
            followed.remove(userId);
        }
    }

    public void post(int tweetId) {
        Tweet tweet = new Tweet(tweetId, DesignTwitter.timeStamp++);
        tweet.setNext(startingTweet);
        startingTweet = tweet;
    }
}
