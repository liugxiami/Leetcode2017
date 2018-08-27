package com.ccsi.leetcode4;

import java.util.*;

public class LC460LFUCache {
    public static void main(String[] args) {
        LC460LFUCache cache=new LC460LFUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
    private int cap;
    private Map<Integer,Integer> map; //key,value
    private Map<Integer,Integer> counts; //key,count
    private TreeMap<Integer,LinkedHashSet<Integer>> lists; //count,keys。TreeMap可以排好序，让
    // 少调用的排在前面；LinkedHashSet可以保存顺序
    public LC460LFUCache(int capacity){
        this.cap=capacity;
        this.map=new HashMap<>();
        this.counts=new HashMap<>();
        this.lists=new TreeMap<>();
    }

    public int get(int key){
        if(!map.containsKey(key))return -1;

        int count=counts.get(key);
        counts.put(key,count+1); //update counts
        //update lists
        lists.get(count).remove(key);
        if(lists.get(count).isEmpty())lists.remove(count);

        if(!lists.containsKey(count+1))lists.put(count+1,new LinkedHashSet<>());
        lists.get(count+1).add(key);
        return map.get(key);
    }

    public void put(int key,int value){
        if(cap==0)return;//坑一个
        if(map.containsKey(key)){
            map.put(key,value);
            get(key);
            return;
        }
        if(map.size()>=cap){
            int lowestCount=lists.firstKey();
            int lowestUseKey=lists.get(lowestCount).iterator().next();
            remove(lowestUseKey);
        }
        map.put(key,value);
        counts.put(key,1);
        if(!lists.containsKey(1)){
            lists.put(1,new LinkedHashSet<>());
        }
        lists.get(1).add(key);
    }

    private void remove(int key){
        if(!map.containsKey(key))return;
        map.remove(key);
        int count=counts.get(key);
        counts.remove(key);
        lists.get(count).remove(key);
        if(lists.get(count).isEmpty())lists.remove(count);
    }
}
