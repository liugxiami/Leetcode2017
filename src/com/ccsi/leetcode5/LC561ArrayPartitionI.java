package com.ccsi.leetcode5;

import java.util.*;

public class LC561ArrayPartitionI {
    public static void main(String[] args) {
        int[] nums={1,4,2,3,6,5};
        System.out.println(arrayPairSum(nums));
    }
    public static int arrayPairSum(int[] nums){
        if(nums==null||nums.length==0)return 0;
        Arrays.sort(nums);
        int sum=0;
        for (int i = 0; i < nums.length; i+=2) {
            sum+=nums[i];
        }
        return sum;
    }
}
