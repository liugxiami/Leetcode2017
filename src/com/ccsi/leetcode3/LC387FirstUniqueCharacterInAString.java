package com.ccsi.leetcode3;

import java.util.*;

/**
 * Created by gxliu on 2018/4/19.
 */
public class LC387FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        String s="leetcode";
        System.out.println(firstUniqueChar1(s));
    }
    //method1,用了两个数组来做缓存
    public static int firstUniqueChar(String s){
        if(s==null||s.length()==0)return -1;
        int len=s.length();
        int[] indexes=new int[26];
        int[] counts=new int[26];
        Arrays.fill(indexes,-1);

        for (int i = 0; i < len; i++) {
            char c=s.charAt(i);
            if(indexes[c-'a']==-1){
                indexes[c-'a']=i;
            }
            counts[c-'a']++;
        }

        int lowest=27;
        for (int i = 0; i < 26; i++) {
            if(counts[i]==1){
                lowest=indexes[i]>lowest?lowest:indexes[i];
            }
        }

        if(lowest==27)return -1;
        return lowest;
    }
    //method2，其实一个数组做缓存就可以了
    public static int firstUniqueChar1(String s){
        if(s==null||s.length()==0)return -1;
        int[] counts=new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            counts[c-'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(counts[c-'a']==1)return i;
        }

        return -1;
    }
}
