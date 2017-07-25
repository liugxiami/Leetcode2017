package com.ccsi.leetcode;

import java.util.Arrays;

/**
 * Created by gxliu on 2017/7/23.
 */
public class LC0163SumClosest {
    public static void main(String[] args) {
        int[] nums={1,1,1,0};
        System.out.println(threeSumClosest1(nums,100));
    }
    //method1,不够快
    public static int threeSumClosest(int[] nums,int target){
        if(nums==null||nums.length<3)return -1;
        int len=nums.length;
        Arrays.sort(nums);
        int bestSum=nums[0]+nums[1]+nums[2];
        for (int i = 0; i < len - 2; i++) {
            int left=i+1;
            int right=len-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(Math.abs(target-bestSum)>Math.abs(target-sum)){
                    bestSum=sum;
                }
                if(sum==target)return target;
                else if(target>sum)left++;
                else right--;
            }
        }
        return bestSum;
    }
    //method2
    public static int threeSumClosest1(int[] nums,int target){
        if(nums==null||nums.length<3)return -1;
        int len=nums.length;
        Arrays.sort(nums);
        int bestSum=nums[0]+nums[1]+nums[2];
        for (int i = 0; i < len - 2; i++) {
            int curr=target-nums[i];
            int left=i+1;
            int right=len-1;
            int temp=twoSum(nums,left,right,curr);
            if(temp+nums[i]==target)return target;
            else{
                if(Math.abs(bestSum-target)>Math.abs(temp+nums[i]-target)){
                    bestSum=temp+nums[i];
                }
            }
        }
        return bestSum;
    }
    private static int twoSum(int[] nums,int left,int right,int target){
        int twosum=nums[left]+nums[right];
        while(left<right){
            int curr=nums[left]+nums[right];
            if(Math.abs(target-twosum)>Math.abs(target-curr))twosum=curr;

            if(curr==target)return target;
            else if(curr<target){
                left++;
            }else{
                right--;
            }
        }
        return twosum;
    }
}
