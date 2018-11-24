package com.ccsi.leetcode5;

public class LC518CoinChangeII {
    public static void main(String[] args) {
        int[] coins={1,2,5};
        System.out.println(change1(10,coins));
    }
    private static int counts;
    public static int change(int amount,int[] coins){
        counts=0;
        helper(amount,0,0,coins);//需要一个当前是多少了，还要一个index，如果没有index的话
        //容易有重复。
        return counts;
    }
    private static void helper(int amount,int total,int index,int[] coins){
        if(total>amount)return;
        if(total==amount){
            counts++;
            return;
        }
        for (int i = index; i < coins.length; i++) {
            total+=coins[i];
            helper(amount,total,i,coins);
            total-=coins[i];
        }
    }
    //method2 DP
    public static int change1(int amount,int[] coins){
        int[][] dp=new int[coins.length+1][amount+1];
        dp[0][0]=1;
        for (int i = 1; i <= coins.length; i++) {
            dp[i][0]=1;
            for (int j = 1; j <=amount; j++) {
                dp[i][j]=dp[i-1][j]+(j>=coins[i-1]?dp[i][j-coins[i-1]]:0);
            }
        }
        return dp[coins.length][amount];
    }
}
