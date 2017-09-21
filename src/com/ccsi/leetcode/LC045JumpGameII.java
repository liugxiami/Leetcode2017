package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/9/19.
 */
public class LC045JumpGameII {
    public static void main(String[] args) {
        int[] arr={0};
        System.out.println(jump2(arr));
    }

    //Runtime Error 超时
    public static int jump(int[] nums){
        if(nums==null||nums.length==0)return -1;
        return helper(nums,0);
    }

    private static int helper(int[] nums,int start){
        if(start==nums.length-1)return 0;

        int curr=nums[start];
        if(curr<=0)return nums.length;

        int minimun=nums.length;
        for (int i = start+1; i <= start+curr; i++) {
            minimun=Math.min(minimun,helper(nums,i));
        }
        return minimun+1;
    }
    //greedy
    public static int jump2(int[] nums){
        if(nums==null||nums.length==0)return -1;
        int lastMax=0,currMax=0;  //lastMax上次能跳的最远距离，currMax当前能跳的最远距离。

        int count=0;
        for (int i = 0; i < nums.length; i++) {
            if(lastMax<i){    //如果上次前面能跳的最远距离已经小于当前位置，需要更新，count+1.
                count++;
                lastMax=currMax;
            }
            currMax=Math.max(currMax,i+nums[i]);
        }
        return count;
    }
}
