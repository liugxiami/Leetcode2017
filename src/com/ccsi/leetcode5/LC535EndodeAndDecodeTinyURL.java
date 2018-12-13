package com.ccsi.leetcode5;

import java.util.*;

public class LC535EndodeAndDecodeTinyURL {
    public static void main(String[] args) {
        LC535EndodeAndDecodeTinyURL solution=new LC535EndodeAndDecodeTinyURL();
        for (int i = 0; i < 100; i++) {
            String longUrl=String.valueOf(i+100);
            String shortUrl=solution.encode(longUrl);
            System.out.println(solution.decode(shortUrl));
        }
    }
    //Encodes a URL to a shortened URL.
    char[] chars={'0','1','2','3','4','5','6','7','8','9',
    'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
    'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    int count=0;
    Map<String,String> map=new HashMap<>();
    public String encode(String longUrl){
        count++;
        StringBuilder sb=new StringBuilder();
        int curr=count;
        while(curr>0){
            int temp=curr%56;
            sb.append(chars[temp]);
            curr/=10;
        }
        map.put(sb.toString(),longUrl);
        return sb.toString();
    }
    //Decode a shortened URL to its original URL.
    public String decode(String shortUrl){
        return map.get(shortUrl);
    }
}
