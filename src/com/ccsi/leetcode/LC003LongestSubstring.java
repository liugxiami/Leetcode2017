package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/7/12.
 */
public class LC003LongestSubstring {
    public static void main(String[] args) {
        String s="pwwkew";
        System.out.println(lengthOfLongestSubstring1(s));
    }
    //1.not a substring,this result is a subsequence
    public static int lengthOfLongestSubstring(String s){
        if(s==null||s.length()==0)return 0;
        int len=s.length();
        Set<Character> set=new HashSet<>();
        for (int i = 0; i < len; i++) {
            Character c=s.charAt(i);
            set.add(c);
        }
        return set.size();
    }
    //2.
    public static int lengthOfLongestSubstring1(String s){
        if(s==null||s.length()==0)return 0;
        int len=s.length();
        int start=0;
        int max=0;
        Set<Character> set=new HashSet<>();//这个set保存的是当前情况下的的不重复substring的字母集合。

        for (int i = 0; i < len; i++) {
            char c=s.charAt(i);
            if(set.contains(c)){
                max=Math.max(max,i-start);

                while(s.charAt(start)!=s.charAt(i)){
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
            }else{
                set.add(c);
            }
        }
        max=Math.max(max,len-start); //还是必须的，比如就一个字母的情况下。
        return max;
    }
}
