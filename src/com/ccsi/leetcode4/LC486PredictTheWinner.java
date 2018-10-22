package com.ccsi.leetcode4;

import java.util.*;

public class LC486PredictTheWinner {
    public static void main(String[] args) {
        int[] nums={1,5,233,7};
        System.out.println(PredictTheWinner2(nums));
    }
    //method1 recursion
    public static boolean PredictTheWinner(int[] nums){
        if(nums.length==1)return true;
        System.out.println(getScore(nums,0,nums.length-1));
        return getScore(nums,0,nums.length-1)>=0;
    }
    //子函数返回值是最大分数差
    private static int getScore(int[] nums,int left,int right){
        if(left==right)return nums[left];
        //是先取左边的还是先取右边的，如果是先取左边的，那么要减去player2取的（也就是下次取的那个数）分数，取右边同理。
        return Math.max(nums[left]-getScore(nums,left+1,right),nums[right]-getScore(nums,left,right-1));
    }
    //method2 因为直接的递归方法有很多的重复计算，可以引入一个数组做缓存
    public static boolean PredictTheWinner1(int[] nums){
        if(nums.length==1)return true;
        int[][] cache=new int[nums.length][nums.length];
        getScore1(nums,0,nums.length-1,cache);
        System.out.println(cache[0][nums.length-1]);
        return cache[0][nums.length-1]>=0;
    }
    private static int getScore1(int[] nums,int left,int right,int[][] cache){
        if(left>right)return 0;
        if(left==right)cache[left][right]=nums[left];
        if(cache[left][right]!=0)return cache[left][right];
        cache[left][right]=Math.max(nums[left]-getScore1(nums,left+1,right,cache),nums[right]-getScore1(nums,left,right-1,cache));
        return cache[left][right];
    }
    //method3 递推
    //dp[i][j]表示玩家1从i到j的能选到的最大值之和，初始为0
    //dp[i][j] = max(nums[i] + min(dp[i + 1][j - 1], dp[i + 2][j]), nums[j] + min(dp[i + 1][j - 1], dp[i][j - 2]))
    public static boolean PredictTheWinner2(int[] nums){
        int size=nums.length;
        if(size==1||size==2)return true;
        int[][] cache=new int[size][size];
        int sum=0;
        //初始化
        for (int i = 0; i < size-1; i++) {
            cache[i][i]=nums[i];
            cache[i][i+1]=Math.max(nums[i],nums[i+1]);
            sum+=nums[i];
        }
        cache[size-1][size-1]=nums[size-1];
        sum+=nums[size-1];
        //递推方程实现
        for (int len=3;len<=size;len++) {
            for (int left=0;left+len<=size;left++) {
                int right=left+len-1;
                cache[left][right]=Math.max(nums[left]+Math.min(cache[left+1][right-1],cache[left+2][right]),
                        nums[right]+Math.min(cache[left][right-2],cache[left+1][right-1]));
            }
        }

        return cache[0][nums.length-1]>=(sum+1)/2;
    }
}
