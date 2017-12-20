package com.ccsi.leetcode2;

import java.util.*;

/**
 * Created by gxliu on 2017/12/19.
 */
public class LC228SummaryRanges {
    public static void main(String[] args) {
        int[] nums={0,2,3,4,6,8,9};
        List<String> res=summaryRanges(nums);
        res.forEach(x-> System.out.println(x));
    }
    public static List<String> summaryRanges(int[] nums){
        List<String> result=new LinkedList<>();
        if(nums==null||nums.length==0)return result;
        int len=nums.length;
        //双指针，一个指前，一个指后，两个指针相同的话，说明是一个元素，不同的话，就是一个范围，之后更新两指针。
        int pre=nums[0];
        int last=nums[0];
        for (int i = 1; i < len; i++) {
            if(nums[i]==nums[i-1]+1){
                last=nums[i];
            }else{
                StringBuilder sb=new StringBuilder();
                if(pre==last) sb.append(pre);
                else sb.append(pre).append('-').append('>').append(last);
                result.add(sb.toString());

                pre=nums[i];
                last=nums[i];
            }
        }
        //要解决最后一个时的问题
        StringBuilder sb=new StringBuilder();
        if(pre==last) sb.append(pre);
        else sb.append(pre).append('-').append('>').append(last);
        result.add(sb.toString());

        return result;
    }
}
