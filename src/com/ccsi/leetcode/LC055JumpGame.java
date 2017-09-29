package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/9/28.
 */
public class LC055JumpGame {
    public static void main(String[] args) {
        int[] a={0,1};
        System.out.println(canJump(a));
    }
    public static boolean canJump(int[] nums){
        if(nums==null||nums.length==0)return true;
        int max=0;
        for (int i = 0; i <=max; i++) {
            if(max<i+nums[i]){
                max=i+nums[i];
            }
            if(max>=nums.length-1)return true;
        }
        return false;
    }
}
