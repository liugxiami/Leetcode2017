package com.ccsi.leetcode4;

import java.util.Iterator;
import java.util.*;

public class LC456132Pattern {
    public static void main(String[] args) {
        int[] nums={-1,3,2,0};
        System.out.println(find132Pattern1(nums));
    }
    public static boolean find132Pattern1(int[] nums){
        if(nums==null||nums.length<3)return false;
        TreeMap<Integer,Integer> interval=new TreeMap<>();
        int first=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]<first)first=nums[i];
            if(nums[i]>first){
                Integer key=interval.lowerKey(nums[i]);
                if(key!=null){
                    if(nums[i]<interval.get(key))return true;
                    while(key!=null&&key>first){
                        interval.remove(key);
                        key=interval.lowerKey(key);
                    }
                }
                interval.put(first,nums[i]);
            }
        }
        return false;
    }
    public static boolean find132Pattern(int[] nums){
        if(nums==null||nums.length<3)return false;
        Map<Long,Long> interval=new HashMap<>();
        long first=(long)nums[0];
        long second=Long.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if(second==Long.MIN_VALUE&&nums[i]<=first)first=nums[i];
            else if(nums[i]>=second){
                second=nums[i];
            }else{
                interval.put(first,second);
                for(Map.Entry entry:interval.entrySet()){
                    if(nums[i]>(long)entry.getKey()&&nums[i]<(long)entry.getValue())return true;
                }
                first=nums[i];
                second=Long.MIN_VALUE;
            }
        }
        return false;
    }
}
