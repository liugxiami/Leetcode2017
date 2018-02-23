package com.ccsi.leetcode3;

import java.util.*;

/**
 * Created by gxliu on 2018/2/22.
 */
public class LC280WiggleSort {
    //Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
    //For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
    public static void main(String[] args) {
        int[] nums={3, 5, 2, 1, 6, 4};
        wiggleSort1(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
    //Method1 0(nlgn)
    public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i <nums.length-1; i+=2) {
            int temp=nums[i];
            nums[i]=nums[i+1];
            nums[i+1]=temp;
        }
    }
    //Method2 O(n)
    public static void wiggleSort1(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            if(i%2==1&&nums[i]<nums[i-1]||i%2==0&&nums[i]>nums[i-1]){
                int temp=nums[i];
                nums[i]=nums[i-1];
                nums[i-1]=temp;
            }
        }
    }
}
