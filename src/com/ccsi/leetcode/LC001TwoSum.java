package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/7/11.
 */
public class LC001TwoSum {
    public static void main(String[] args) {
        int[] nums={2,7,11,15};
        int[] result=twoSum(nums,9);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
    public static int[] twoSum(int[] nums,int target){
        int[] result=new int[2];
        if(nums==null||nums.length<=1)return result;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp=target-nums[i];
            if(!map.containsKey(nums[i])){
                map.put(temp,i);
            }else{
                result[0]=map.get(nums[i]);
                result[1]=i;
            }
        }
        return result;
    }
}
