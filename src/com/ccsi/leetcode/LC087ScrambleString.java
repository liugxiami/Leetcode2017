package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/10/15.
 */
public class LC087ScrambleString {
    public static void main(String[] args) {
        System.out.println(isSameChars("a","a"));
    }

    public static boolean isScramble(String s1,String s2){
        if(s1==null&&s2==null)return true;
        if(s1==null||s2==null)return false;
        if(s1.length()==0&&s2.length()==0)return true;
        if(s1.length()==0||s2.length()==0)return false;
        if(s1.length()!=s2.length())return false;

        int len=s1.length();

        if(s1.equals(s2))return true;

        for (int i = 1; i < len; i++) {
            String s1Left=s1.substring(0,i);
            String s1Right=s1.substring(i);

            //case1
            String s2Left=s2.substring(0,i);
            String s2Right=s2.substring(i);

            if(isSameChars(s1Left,s2Left)&&isSameChars(s1Right,s2Right)
                    &&isScramble(s1Left,s2Left)&&isScramble(s1Right,s2Right))return true;

            //case2
            String c2Left=s2.substring(len-i);
            String c2Right=s2.substring(0,len-i);

            if(isSameChars(s1Left,c2Left)&&isSameChars(s1Right,c2Right)
                    &&isScramble(s1Left,c2Left)&&isScramble(s1Right,c2Right))return true;
        }
        return false;
    }
    private static boolean isSameChars(String s1,String s2){
        if(s1.equals(s2))return true;
        if(s1.length()!=s2.length())return false;
        int len=s1.length();

        char[] chars1=s1.toCharArray();
        char[] chars2=s2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        for (int i = 0; i < len; i++) {
            if(chars1[i]!=chars2[i])return false;
        }
        return true;
    }
}
