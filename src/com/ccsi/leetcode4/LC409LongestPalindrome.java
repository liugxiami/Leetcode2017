package com.ccsi.leetcode4;

import java.util.*;

/**
 * Created by gxliu on 2018/5/20.
 */
public class LC409LongestPalindrome {
    public static int longestPalindrome(String s){
        if(s==null||s.length()==0)return 0;
        Set<Character> set=new HashSet<>();
        int result=0;
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(set.contains(c)){
                set.remove(c);
                result+=2;
            }else set.add(c);
        }
        return set.isEmpty()?result:result+1;
    }
    //same as above but less one variable
    public static int longestPalindrome1(String s){
        if(s==null||s.length()==0)return 0;
        Set<Character> set=new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(set.contains(c))set.remove(c);
            else set.add(c);
        }

        return s.length()-(set.isEmpty()?0:(set.size()-1));
    }

    public static void main(String[] args) {
        String s="abccccdd";
        System.out.println(longestPalindrome1(s));
    }
}
