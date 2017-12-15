package com.ccsi.leetcode2;

import java.util.*;

/**
 * Created by gxliu on 2017/12/14.
 */
public class LC219ContainsDuplicateII {
    public static void main(String[] args) {
        int[] nums={99,99};
        System.out.println(containsNearByDuplicate(nums,3));
    }
    public static boolean containsNearByDuplicate(int[] nums,int k){
        if(nums==null||nums.length<2||k<1)return false;
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(i-k>=0){
                if(!set.add(nums[i]))return true;
                set.remove(nums[i-k]);
            }else{
                if(!set.add(nums[i]))return true;
            }
        }
        return false;
    }

    public static boolean containsNearByDuplicate1(int[] nums,int k){
        if(nums==null||nums.length<2||k<1)return false;
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!set.add(nums[i]))return true;
            if(i-k>=0){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}
