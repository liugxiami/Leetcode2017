package com.ccsi.leetcode3;

/**
 * Created by gxliu on 2018/4/1.
 */
public class LC367ValidPerfectSquare {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(808201));
    }
    public static boolean isPerfectSquare(int num){
        if(num<0)return false;
        if(num==1)return true;
        long low=0;
        long high=num;

        while(low+1<high){ //这样可以保证low和high之间必定还有一个数。否则就可以不用再迭代了。
            long medium=low+(high-low)/2;
            long temp=medium*medium;
            if(temp==num)return true;
            if(num<temp)high=medium;
            else low=medium;
        }
        return false;
    }
}
