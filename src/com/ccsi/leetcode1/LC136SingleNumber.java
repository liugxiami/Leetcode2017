package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/11/13.
 */
public class LC136SingleNumber {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,5,4,3,2,1};
        System.out.println(singleNumber1(nums));
    }
    //method1 Set
    public static int singleNumber(int[] nums){
        Set<Integer> set=new HashSet<>();
        for (Integer num:nums) {
            if(set.contains(num)){
                set.remove(num);
            }else{
                set.add(num);
            }
        }
        return set.iterator().next();
    }
    //method2 bit-maniputlation
    public static int singleNumber1(int[] nums){
        int result=nums[0];
        for (int i = 1; i < nums.length; i++) {
            result^=nums[i];
        }
        return result;
    }
}
