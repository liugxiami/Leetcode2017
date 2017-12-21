package com.ccsi.leetcode2;

/**
 * Created by gxliu on 2017/12/20.
 */
public class LC231PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo1(9));
    }
    public static boolean isPowerOfTwo(int n){
        if(n<=0)return false;
        return (n&(n-1))==0;
    }
    public static boolean isPowerOfTwo1(int n){
        if(n<=0)return false;
        int count=0;
        while(n!=0){
            if((n&1)==1)count++;
            n>>=1;
        }
        return count==1;
    }
}
