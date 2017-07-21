package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/7/20.
 */
public class LC013RomanToInteger {
    public static void main(String[] args) {
        String s="I";
        System.out.println(romanToInteger(s));
    }
    public static int romanToInteger(String s){
        if(s==null||s.length()==0)return 0;
        Map<Character,Integer> dict=new HashMap<>();
        dict.put('M',1000);
        dict.put('D',500);
        dict.put('C',100);
        dict.put('L',50);
        dict.put('X',10);
        dict.put('V',5);
        dict.put('I',1);

        int result=dict.get(s.charAt(0));
        int len=s.length();
        for (int i = 1; i < len; i++) {
            result=result+dict.get(s.charAt(i));
            if(dict.get(s.charAt(i))>dict.get(s.charAt(i-1))){
                result-=dict.get(s.charAt(i-1))*2;
            }
        }
        return result;
    }
}
