package com.ccsi.leetcode5;

import java.util.*;

public class LC524LongestWordInDictionaryThroughDeleting {
    public static void main(String[] args) {
        //List<String> d=Arrays.asList("ale","apple","monkey","plea");
        List<String> d=Arrays.asList("ba","ab","a","b");
        System.out.println(findLongestWord("bab",d));
    }
    public static String findLongestWord(String s, List<String> d){
        PriorityQueue<String> pq=new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()<o2.length())return 1;
                else if(o1.length()>o2.length())return -1;
                else{
                    int index=0;
                    while(index<o1.length()){
                        if(o1.charAt(index)>o2.charAt(index))return 1;
                        else if(o1.charAt(index)<o2.charAt(index))return -1;
                        index++;
                    }
                    return 0;
                }
            }
        });
        for(String str:d)pq.offer(str);
        while(!pq.isEmpty()){
            String curr=pq.poll();
            if(isSubstring(curr,s))return curr;
        }

        return "";
    }
    private static boolean isSubstring(String curr,String target){
        int index=0;
        for (int i = 0; i < target.length(); i++) {
            if(curr.charAt(index)==target.charAt(i))index++;
            if(index==curr.length())return true;
        }
        return false;
    }
}
