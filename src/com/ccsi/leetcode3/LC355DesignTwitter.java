package com.ccsi.leetcode3;
import java.util.*;
/**
 * Created by gxliu on 2018/3/25.
 */
public class LC355DesignTwitter {
    public static void main(String[] args) {
        LC355DesignTwitter twitter=new LC355DesignTwitter();
        twitter.postTweet(1,5);

        twitter.follow(1,2);
        twitter.postTweet(2,6);
        List<Integer> result=twitter.getNewsFeed(1);
        twitter.unfollow(1,2);
        List<Integer> result1=twitter.getNewsFeed(1);
    }
    private class Tweet{
        int time; //题目要求显示最新的10条tweet，那么给tweet一个时间的字段，方便排序
        int tweetId;
        public Tweet(int time,int tweetId){
            this.time=time;
            this.tweetId=tweetId;
        }
    }
    int timeStamp;
    //每个人的tweets用hashMap存储, key---userId,value---Tweet，用PQ可以给tweet排序，方便取最新的feed
    Map<Integer,List<Tweet>> twitters;
    //关系网 key---followerId，value---sfolloweeId，用set为了预防重复。
    Map<Integer,Set<Integer>> relations;
    /** Initialize your data structure here. */
    public LC355DesignTwitter() {
        this.timeStamp=0;
        this.twitters=new HashMap<>();
        this.relations=new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet newTweet=new Tweet(timeStamp++,tweetId);

        List<Tweet> tweets;
        if(!twitters.containsKey(userId)){
            tweets=new ArrayList<Tweet>();
        }else{
            tweets=twitters.get(userId);
        }

        tweets.add(newTweet);
        twitters.put(userId,tweets);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result=new ArrayList<>();
        PriorityQueue<Tweet> candidates=new PriorityQueue<>((a,b)->(b.time-a.time));

        //自己的feeds
        if(twitters.containsKey(userId)){
            List<Tweet> tweetsByOwner=twitters.get(userId);
            for(Tweet tweet:tweetsByOwner){
                candidates.offer(tweet);
            }
        }

        //自己follow的其他的人的feeds。
        if(relations.containsKey(userId)){
            Set<Integer> followees=relations.get(userId);
            for(Integer followee:followees){
                if(twitters.containsKey(followee)){
                    List<Tweet> twittersByFollowee=twitters.get(followee);
                    for(Tweet tweet:twittersByFollowee){
                        candidates.offer(tweet);
                    }
                }
            }
        }

        //取出前10个就可以了。
        int counter=10;
        while(!candidates.isEmpty()&&counter-->0){
            result.add(candidates.poll().tweetId);
        }
        return result;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(followerId==followeeId)return; //自己不follow自己。
        if(!relations.containsKey(followerId)){
            relations.put(followerId,new HashSet<>());
        }
        Set<Integer> followees=relations.get(followerId);
        followees.add(followeeId);
        relations.put(followerId,followees);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followerId==followeeId)return;
        if(!relations.containsKey(followerId))return;
        Set<Integer> followees=relations.get(followerId);
        followees.remove(followeeId);
        if(followees.isEmpty())relations.remove(followerId);
        else relations.put(followerId,followees);
    }
}
