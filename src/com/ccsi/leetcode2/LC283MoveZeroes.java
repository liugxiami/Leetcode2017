package com.ccsi.leetcode2;

/**
 * Created by gxliu on 2018/1/5.
 */
public class LC283MoveZeroes {
    public static void main(String[] args) {
        int[] nums={0,1,0,3,12};
        moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
    public static void moveZeroes(int[] nums){
        if(nums==null||nums.length<=1)return;
        int len=nums.length;
        int index=0;
        for (int i = 0; i < len; i++) {
            if(nums[i]!=0)nums[index++]=nums[i];
        }
        while(index<len){
            nums[index++]=0;
        }
    }
}
