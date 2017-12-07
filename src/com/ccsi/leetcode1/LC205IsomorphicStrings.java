package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/12/6.
 */
public class LC205IsomorphicStrings {
    public static void main(String[] args) {
        String s="q";
        String t="a";
        System.out.println(isIsomorphic(s,t));
    }
    public static boolean isIsomorphic(String s,String t){
        if(s==null&&t==null)return true;
        if(s==null||t==null)return false;
        if(s.length()!=t.length())return false;
        int len=s.length();
        Map<Character,Character> map=new HashMap<>(); //保存出现过的字符对
        Set<Character> set=new HashSet<>();//反查
        for (int i = 0; i < len; i++) {
            char sc=s.charAt(i);
            char tc=t.charAt(i);
            if(map.containsKey(sc)){
                if(tc!=map.get(sc))return false;
            }else{
                if(set.contains(tc))return false;
                else {
                    map.put(sc,tc);
                    set.add(tc);
                }

            }
        }
        return true;
    }
}
