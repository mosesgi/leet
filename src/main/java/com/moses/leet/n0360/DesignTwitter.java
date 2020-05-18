package com.moses.leet.n0360;

import java.util.*;

public class DesignTwitter {

    class Twitter {
        Map<Integer, Set<Integer>> followingMap;
        Map<Integer, List<Tweet>> userPosts;

        /** Initialize your data structure here. */
        public Twitter() {
            followingMap = new HashMap<>();
            userPosts = new HashMap<>();
        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            userPosts.putIfAbsent(userId, new LinkedList<>());
            Tweet t = new Tweet(tweetId);
            userPosts.get(userId).add(0, t);
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            PriorityQueue<Tweet> p = new PriorityQueue<>((o1, o2) -> o1.internalId - o2.internalId);    //ascending
            if(userPosts.containsKey(userId)){
                for(Tweet t : userPosts.get(userId)){
                    if(p.size() >= 10){
                        break;
                    }
                    p.offer(t);
                }
            }
            if(followingMap.containsKey(userId)) {
                for (int uid : followingMap.get(userId)) {
                    for (Tweet t : userPosts.get(uid)) {
                        if (p.size() < 10) {
                            p.offer(t);
                        } else {
                            if (t.internalId < p.peek().internalId) {
                                break;
                            } else {
                                p.offer(t);
                                p.poll();
                            }
                        }
                    }
                }
            }

            List<Integer> res = new LinkedList<>();
            while(!p.isEmpty()){
                res.add(0, p.poll().displayId);
            }
            return res;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            if(followerId == followeeId){
                return;
            }
            userPosts.putIfAbsent(followeeId, new LinkedList<>());
            userPosts.putIfAbsent(followerId, new LinkedList<>());
            followingMap.putIfAbsent(followerId, new HashSet<>());
            followingMap.get(followerId).add(followeeId);
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            if(followerId == followeeId || !followingMap.containsKey(followerId)){
                return;
            }
            followingMap.get(followerId).remove(followeeId);
        }

        int ID = 1;
        class Tweet{
            int internalId;
            int displayId;
            Tweet(int displayId){
                this.internalId = ID;
                this.displayId = displayId;
                ID++;
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
