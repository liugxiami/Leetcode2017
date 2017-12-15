package com.ccsi.leetcode2;

import java.util.*;

/**
 * Created by gxliu on 2017/12/14.
 */
public class LC217ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums={1,2,3,2};
        System.out.println(containsDuplicate1(nums));
    }
    //method1,Set
    public static boolean containsDuplicate(int[] nums){
        if(nums==null||nums.length<2)return false;
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!set.add(nums[i]))return true;
        }
        return false;
    }
    //method2 Arrays.sort
    public static boolean containsDuplicate1(int[] nums){
        if(nums==null||nums.length<2)return false;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==nums[i-1])return true;
        }
        return false;
    }
}
