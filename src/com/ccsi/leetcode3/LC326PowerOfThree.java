package com.ccsi.leetcode3;

/**
 * Created by gxliu on 2018/2/25.
 */
public class LC326PowerOfThree {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(1));
    }
    public static boolean isPowerOfThree(int n){
        if(n<=0)return false;
        while(n>0){
            if(n==1)return true;
            if(n%3==0)n/=3;
            else break;
        }
        return false;
    }
    public static boolean isPowerOfThree1(int n){
        if(n<=0)return false;
        return n>0&&1162261467%n==0; //1162261467=3^19 最大的3的n次方的正整数。
    }
}
