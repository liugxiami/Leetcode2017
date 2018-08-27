package com.ccsi.leetcode4;

public class LC459RepeatedSubstringPattern {
    public static void main(String[] args) {
        String s="abab";
        System.out.println(repeatedSubstringPattern(s));
    }
    public static boolean repeatedSubstringPattern(String s){
        if(s==null||s.length()<=1)return false;
        int len=s.length();
        for (int i = 1; i <= len / 2; i++) {
            if(len%i==0){
                int subLen=i;
                String subStr=s.substring(0,subLen);
                StringBuilder sb=new StringBuilder();
                int repeats=len/subLen;
                while(repeats-->0)sb.append(subStr);
                if(sb.toString().equals(s))return true;
            }
        }
        return false;
    }
}
