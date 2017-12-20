package com.ccsi.leetcode2;

import java.util.*;

/**
 * Created by gxliu on 2017/12/19.
 */
public class LC229MajorityElementII {
    //Moore voting
    public static List<Integer> majorityElement(int[] nums){
        List<Integer> result=new ArrayList<>();
        if(nums==null||nums.length==0)return result;

        //超过n/3的数字个数不会超过2个。超过n/2的数字个数不会超过1个。
        int len=nums.length;
        int first=0;
        int firstCount=0;
        int second=0;
        int secondCount=0;
        //第一遍：投票
        for (int i = 0; i < len; i++) {
            if(nums[i]==first)firstCount++;
            else if(nums[i]==second)secondCount++;
            else if(firstCount==0){
                first=nums[i];
                firstCount=1;
            }
            else if(secondCount==0){
                second=nums[i];
                secondCount=1;
            }
            else {
                firstCount--;
                secondCount--;
            }
        }
        //第二遍，检查切实的次数
        firstCount=secondCount=0;
        for (int i = 0; i < len; i++) {
            if(nums[i]==first)firstCount++;
            else if(nums[i]==second)secondCount++;
        }
        //如果次数超过n/3，那么就入结果集
        if(firstCount>len/3)result.add(first);
        if(secondCount>len/3)result.add(second);

        return result;
    }

    public static void main(String[] args) {
        int[] nums={2};
        List<Integer> res=majorityElement(nums);
        res.forEach(x-> System.out.println(x));
    }
}
