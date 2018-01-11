package com.ccsi.leetcode2;

import com.sun.org.apache.regexp.internal.RE;

import java.util.*;

/**
 * Created by gxliu on 2018/1/9.
 */
public class LC299BullsAndCows {
    public static void main(String[] args) {
        String secret="1123";
        String guess="0111";
        System.out.println(getHint(secret,guess));
    }
    public static String getHint(String secret,String guess){
        if(secret==null||guess==null||secret.length()!=guess.length())return "0A0B";
        int len=secret.length();
        Map<Character,Integer> map=new HashMap<>();

        int bulls=0;
        int cows=0;

        for (int i = 0; i < len; i++) {
            char c=secret.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,0);
            }
            map.put(c,map.get(c)+1);
        }

        for (int i = 0; i < len; i++) {
            char c=guess.charAt(i);
            if(c==secret.charAt(i))bulls++;

            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                cows++;
                if(map.get(c)==0)map.remove(c);
            }
        }

        cows-=bulls;

        StringBuilder sb=new StringBuilder();
        sb.append(bulls).append("A").append(cows).append("B");
        return sb.toString();
    }
}
