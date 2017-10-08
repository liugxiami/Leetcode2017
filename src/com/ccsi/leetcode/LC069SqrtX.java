package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/10/7.
 */
public class LC069SqrtX {
    public static void main(String[] args) {
        System.out.println(mySqrt(Integer.MAX_VALUE));
    }
    public static int mySqrt(int x){
        if(x<=1)return x;
        int left=0;
        int right=x;

        while(left<=right){
            int mid=left+(right-left)/2;
            if(mid==x/mid)return mid;
            if(mid<x/mid)left=mid+1;
            else right=mid-1;
        }

        return right;
    }
}
