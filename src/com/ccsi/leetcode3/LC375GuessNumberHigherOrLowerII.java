package com.ccsi.leetcode3;

/**
 * Created by gxliu on 2018/4/6.
 */
public class LC375GuessNumberHigherOrLowerII {
    public static void main(String[] args) {
        System.out.println(getMoneyAmount(10));
    }
    public static int getMoneyAmount(int n){
        int[][] dp=new int[n+1][n+1]; //表示从数字i到j之间猜中任意一个数字最少需要花费的钱数
        for (int left = n-1; left > 0; left--) {
            for (int right = left+1; right <= n; right++) {
                int global_min=Integer.MAX_VALUE;
                for (int i = left; i < right; i++) {
                    int local_max=i+Math.max(dp[left][i-1],dp[i+1][right]);
                    global_min=Math.min(global_min,local_max);
                }
                dp[left][right]=global_min;
            }
        }
        return dp[1][n];
    }
}
