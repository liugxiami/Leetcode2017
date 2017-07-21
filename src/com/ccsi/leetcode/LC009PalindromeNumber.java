package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/7/18.
 */
public class LC009PalindromeNumber {
    public static void main(String[] args) {
        int x=31213;
        System.out.println(isPalindrome(x));
    }
    public static boolean isPalindrome(int x){
        if(x<0)return false;
        if(x<10)return true;
        int temp=x;
        long res=0;
        while(x>0){
            res=res*10+x%10;
            x/=10;
            if(res>Integer.MAX_VALUE)return false;
        }
        return temp==(int)res;
    }
}
