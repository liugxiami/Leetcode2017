package com.ccsi.leetcode2;

import java.util.Arrays;

/**
 * Created by gxliu on 2018/1/26.
 */
public class LC312BurstBalloons {
    public static void main(String[] args) {
        int[] nums={3,1,5,8};
        System.out.println(maxCoins(nums));
    }
    //Divide and conquer
    public static int maxCoins(int[] nums){
        if(nums==null||nums.length==0)return 0;
        int len=nums.length;
        if(len==1)return nums[0];
        int[] numbers=new int[len+2];
        numbers[0]=1;
        for (int i = 0; i < len; i++) {
            numbers[i+1]=nums[i];
        }
        numbers[len+1]=1;

        int[][] dp=new int[len+2][len+2]; //dp[i][j]表示打破i到j之间的气球的最大积分。
        divide(numbers,dp,1,len);
        return dp[1][len];
    }
    //最后的剩下一个气球为i的时候，可以获得的分数为：nums[-1]*nums[i]*nums[n].
    //dp[i][j] = max(dp[i][j], dp[i][m – 1] + nums[i – 1] * nums[m] * nums[j + 1] + dp[m + 1][j]);
    public static int divide(int[] nums,int[][] dp,int start,int end){
        if(dp[start][end]>0)return dp[start][end];
        int ans=0;
        for (int i = start; i <= end; i++) {
            ans=Math.max(ans,nums[start-1]*nums[i]*nums[end+1]+
                    divide(nums,dp,start,i-1)+divide(nums,dp,i+1,end));
        }
        dp[start][end]=ans;
        return ans;
    }
}
