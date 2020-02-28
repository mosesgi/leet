package com.moses.leet.n0360;

import java.util.*;

public class DesignTwitter {

    class Twitter {
        Map<Integer, Set<Integer>> followedByMap;
        Map<Integer, Set<Tweet>> selfTweets;
        Map<Integer, TreeSet<Tweet>> userFeeds;

        /** Initialize your data structure here. */
        public Twitter() {
            followedByMap = new HashMap<>();
            selfTweets = new HashMap<>();
            userFeeds = new HashMap<>();
        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            initialize(userId);
            Tweet t = new Tweet(tweetId);
            selfTweets.get(userId).add(t);

            for(Integer id : followedByMap.get(userId)){
                if(!userFeeds.containsKey(id)){
                    TreeSet<Tweet> set = new TreeSet<Tweet>();
                    userFeeds.put(id, set);
                }
                userFeeds.get(id).add(t);
            }
        }

        private void initialize(int userId) {
            if(!selfTweets.containsKey(userId)){
                Set<Tweet> set = new HashSet<>();
                selfTweets.put(userId, set);
            }
            if(!followedByMap.containsKey(userId)){
                Set<Integer> set = new HashSet<>();
                set.add(userId);
                followedByMap.put(userId, set);
            }
            if(!userFeeds.containsKey(userId)){
                userFeeds.put(userId, new TreeSet<>());
            }
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            initialize(userId);
            TreeSet<Tweet> tweets = userFeeds.get(userId);
            List<Integer> list = new ArrayList<>();
            int k=0;
            for(Tweet t: tweets){
                list.add(t.displayId);
                k++;
                if(k==10){
                    break;
                }
            }
            return list;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            if(followerId == followeeId){
                return;
            }
            initialize(followerId);
            initialize(followeeId);
            followedByMap.get(followeeId).add(followerId);

            TreeSet<Tweet> userTweets = userFeeds.get(followerId);
            userTweets.addAll(selfTweets.get(followeeId));
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            if(followerId == followeeId){
                return;
            }
            initialize(followerId);
            initialize(followeeId);
            followedByMap.get(followeeId).remove(followerId);
            if(userFeeds.containsKey(followerId) && selfTweets.containsKey(followeeId)){
                Set<Tweet> list = userFeeds.get(followerId);
                Iterator<Tweet> iter = list.iterator();
                Set<Tweet> followeeTweets = selfTweets.get(followeeId);
                while(iter.hasNext()){
                    Tweet tweetId = iter.next();
                    if(followeeTweets.contains(tweetId)){
                        iter.remove();
                    }
                }
            }
        }

        int ID = 1;
        class Tweet implements Comparable<Tweet>{
            int internalId;
            int displayId;
            Tweet(int displayId){
                this.internalId = ID;
                this.displayId = displayId;
                ID++;
            }

            @Override
            public int compareTo(Tweet o) {
                return o.internalId - this.internalId;
            }

            @Override
            public int hashCode() {
                return internalId;
            }

            @Override
            public boolean equals(Object obj) {
                Tweet o = (Tweet)obj;
                return this.internalId == o.internalId;
            }
        }
    }

    public static void main(String[] args) {
        Twitter t;

        t = new DesignTwitter().new Twitter();
        t.postTweet(1,5);
        t.follow(1,2);
        t.follow(2,1);
        System.out.println(Arrays.toString(t.getNewsFeed(2).toArray()));
        t.postTweet(2,6);
        System.out.println(Arrays.toString(t.getNewsFeed(1).toArray()));
        t.unfollow(2,1);
        System.out.println(Arrays.toString(t.getNewsFeed(2).toArray()));


        t = new DesignTwitter().new Twitter();
        t.postTweet(1,1);
        System.out.println(Arrays.toString(t.getNewsFeed(1).toArray()));
        t.follow(2,1);
        System.out.println(Arrays.toString(t.getNewsFeed(2).toArray()));
        t.unfollow(2,1);
        System.out.println(Arrays.toString(t.getNewsFeed(2).toArray()));

        t = new DesignTwitter().new Twitter();
        t.postTweet(1,1);
        System.out.println(Arrays.toString(t.getNewsFeed(1).toArray()));
        t.follow(2,1);
        System.out.println(Arrays.toString(t.getNewsFeed(2).toArray()));
        t.unfollow(2,1);
        System.out.println(Arrays.toString(t.getNewsFeed(2).toArray()));
    }


}
