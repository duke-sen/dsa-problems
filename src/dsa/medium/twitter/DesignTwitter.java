package dsa.medium.twitter;

import java.util.*;

public class DesignTwitter {
    public static int timeStamp = 0;
    private Map<Integer, User> userMap;

    public DesignTwitter() {
        this.userMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            User user = new User(userId);
            userMap.put(userId, user);
        }
        userMap.get(userId).post(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        if (!userMap.containsKey(userId))
            return result;
        Set<Integer> usersWhoAreFollowedByThisUser = userMap.get(userId).getFollowed();
        PriorityQueue<Tweet> tweetsByUserId = new PriorityQueue<>(usersWhoAreFollowedByThisUser.size(),
                (a, b) -> (b.getTime() - a.getTime()));

        for (int userWhoAreFollowedByThisUser : usersWhoAreFollowedByThisUser) {
            Tweet tweetByThisUser = userMap.get(userWhoAreFollowedByThisUser).getStartingTweet();
            if (tweetByThisUser != null) {
                tweetsByUserId.add(tweetByThisUser);
            }
        }

        int maxCountOfTweets = 0;
        while (!tweetsByUserId.isEmpty() && maxCountOfTweets < 10) {
            Tweet tweet = tweetsByUserId.poll();
            result.add(tweet.getId());
            maxCountOfTweets++;

            if (tweet.getNext() != null) {
                tweetsByUserId.add(tweet.getNext());
            }
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            User user = new User(followerId);
            userMap.put(followerId,user);
        }
        if (!userMap.containsKey(followeeId)) {
            User user = new User(followeeId);
            userMap.put(followeeId, user);
        }

        userMap.get(followerId).follow(followeeId);
    }
    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)) {
            userMap.get(followerId).unFollow(followeeId);
        }
    }
}




