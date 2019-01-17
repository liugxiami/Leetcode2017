package com.ccsi.leetcode5;

import java.util.ArrayList;
import java.util.List;

public class LC564FindTheClosestPalindrome {
    public static void main(String[] args) {
        System.out.println(nearestPalindromic("12321"));
    }
    public static String nearestPalindromic(String n){
        if(n==null||n.length()<2)return n;
        int len=n.length();
        int i=(len%2==0)?len/2-1:len/2; //左半部的截断和长度是奇数个还是偶数个有关，12345取123，123456取123
        long left=Long.valueOf(n.substring(0,i+1)); //左闭右开

        List<Long> list=new ArrayList<>();
        //比如12345，left=123
        list.add(getPalindrome(left+1,len%2==0)); //12421
        list.add(getPalindrome(left-1,len%2==0)); //12221
        list.add(getPalindrome(left,len%2==0)); //12321
        list.add((long)Math.pow(10,len-1)-1); //9999
        list.add((long)Math.pow(10,len)+1);   //100001

        long diff=Long.MAX_VALUE;
        long res=0;
        long nn=Long.valueOf(n);
        for(long curr:list){
            if(curr==nn)continue; //如果自己就是一个palindrome
            if(Math.abs(curr-nn)<diff){
                diff=Math.abs(curr-nn);
                res=curr;         //找最靠近的palindrome
            }else if(Math.abs(curr-nn)==diff){
                res=Math.min(res,curr); //如果有两个的话，找小的那个一个
            }
        }
        return String.valueOf(res);
    }
    private static long getPalindrome(long left,boolean isEven){
        long res=left;
        if(!isEven)left/=10;
        while(left>0){
            res=res*10+left%10; //右半部是左半部反过来，对10取余正好。
            left/=10;
        }
        return res;
    }
}
