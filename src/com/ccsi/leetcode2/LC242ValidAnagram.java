package com.ccsi.leetcode2;

import java.util.*;

/**
 * Created by gxliu on 2017/12/28.
 */
public class LC242ValidAnagram {
    public static void main(String[] args) {
        String s="anagram";
        String t="nagarem";
        System.out.println(isAnagram1(s,t));
    }
    //method 1
    public static boolean isAnagram(String s,String t){
        if(s==null&&t==null)return true;
        if(s==null||t==null)return false;
        if(s.length()==0&&t.length()==0)return true;
        if(s.length()!=t.length())return false;

        int len=s.length();
        int[] cache=new int[26];
        for (int i = 0; i < len; i++) { //放在同一个循环里
            cache[s.charAt(i)-'a']++;
            cache[t.charAt(i)-'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if(cache[i]!=0)return false;
        }

        return true;
    }
    //method 2 HashMap，特别是对应unicode时用，稍微慢一些。
    public static boolean isAnagram1(String s,String t){
        if(s==null&&t==null)return true;
        if(s==null||t==null)return false;
        if(s.length()==0||t.length()==0)return true;
        if(s.length()!=t.length())return false;
        int len=s.length();

        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < len; i++) {
            char ch=s.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch,0);
            }
            map.put(ch,map.get(ch)+1);
        }

        for (int i = 0; i < len; i++) {
            char ch=t.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0)map.remove(ch);
            }else return false;
        }

        return map.isEmpty();
    }
}
