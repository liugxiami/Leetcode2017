package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/7/18.
 */
public class LC007ReverseInteger {
    public static void main(String[] args) {
        int x=Integer.MAX_VALUE;
        System.out.println(reverse(x-1));
    }
    public static int reverse(int x){
        if(x==0||x==Integer.MIN_VALUE)return 0;
        int flag=1;

        if(x<0){
            flag=-1;
            x=-x;
        }

        long result=0;
        while(x>0){
            result=result*10+x%10;
            x/=10;
            if(result>Integer.MAX_VALUE)return 0;
        }
        return (int)result*flag;
    }
}
