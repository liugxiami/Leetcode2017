package com.ccsi.leetcode3;

import java.util.*;

/**
 * Created by gxliu on 2018/2/22.
 */
public class LC324WiggleSortII {
    public static void main(String[] args) {
        int[] nums={3, 5, 2, 1, 6, 4};
        wiggleSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
    public static void wiggleSort(int[] nums){
        Arrays.sort(nums);
        int len=nums.length;
        int medium=(len-1)/2;
        int[] copy=nums.clone();
        int bigIndex=len-1;
        int smallIndex=medium;
        for (int i = 0; i < len; i++) {
            if(i%2==0)nums[i]=copy[smallIndex--];
            else nums[i]=copy[bigIndex--];
        }
    }
}
