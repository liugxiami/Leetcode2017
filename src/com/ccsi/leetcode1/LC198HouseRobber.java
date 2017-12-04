package com.ccsi.leetcode1;

/**
 * Created by gxliu on 2017/12/3.
 */
public class LC198HouseRobber {
    public static void main(String[] args) {
        int[] nums={3,2,4,5,7,2};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums){
        if(nums==null||nums.length==0)return 0;
        int len=nums.length;
        int[] dp=new int[len];
        dp[0]=nums[0];
        if(len==1)return dp[0];
        dp[1]=Math.max(nums[0],nums[1]);

        for (int i = 2; i < len; i++) {
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }

        return dp[len-1];
    }
}
