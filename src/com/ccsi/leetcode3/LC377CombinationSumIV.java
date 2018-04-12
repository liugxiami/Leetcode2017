package com.ccsi.leetcode3;

import java.util.Arrays;

/**
 * Created by gxliu on 2018/4/11.
 */
public class LC377CombinationSumIV {
    public static void main(String[] args) {
        int[] nums={4,1,2};
        System.out.println(combinationSum41(nums,32));
    }
    private static int count=0;
    public static int combinationSum4(int[] nums,int target){
        if(nums==null||nums.length==0||target<0)return 0;
        helper(nums,0,target);
        return count;
    }
    private static void helper(int[] nums,int sum,int target){
        if(sum>target)return;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if(sum==target){
                count++;
                return;
            }
            helper(nums,sum,target);
            sum-=nums[i];
        }
    }
    //DP
    public static int combinationSum41(int[] nums,int target){
        if(nums==null||nums.length==0||target<0)return 0;
        int[] cache=new int[target+1];
        cache[0]=1;
        for (int i = 1; i <= target; i++) {
            for(int num:nums){
                if(i>=num)cache[i]+=cache[i-num];
            }
        }
        return cache[target];
    }
}
