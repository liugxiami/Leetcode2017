package com.ccsi.leetcode4;

import java.util.*;

public class LC451SortCharactersByFrequency {
    public static void main(String[] args) {
        String s="Aabb";
        System.out.println(frequencySort(s));
    }
    //结合hashMap和PriorityQueue
    public static String frequencySort(String s){
        if(s==null||s.length()<=1)return s;
        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(!map.containsKey(c))map.put(c,1);
            else map.put(c,map.get(c)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> pq=new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        pq.addAll(map.entrySet());
        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry<Character,Integer> entry=pq.poll();
            int count=entry.getValue();
            char c=entry.getKey();
            while(count-->0)sb.append(c);
        }
        return sb.toString();
    }

}
