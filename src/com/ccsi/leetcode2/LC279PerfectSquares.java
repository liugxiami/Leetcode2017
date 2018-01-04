package com.ccsi.leetcode2;

import java.util.Arrays;

/**
 * Created by gxliu on 2018/1/3.
 */
public class LC279PerfectSquares {
    public static void main(String[] args) {
        System.out.println(numSquares(4));
    }
    public static int numSquares(int n){
        if(n==1)return 1;
        int[] cache=new int[n+1];
        Arrays.fill(cache,n);
        cache[0]=0;
        cache[1]=1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j*j <= i; j++) {
                cache[i]=Math.min(cache[i],cache[i-j*j]+1);
            }
        }
        return cache[n];
    }
}
