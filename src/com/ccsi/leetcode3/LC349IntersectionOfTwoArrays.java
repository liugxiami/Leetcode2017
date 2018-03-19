package com.ccsi.leetcode3;

import java.util.*;

/**
 * Created by gxliu on 2018/3/18.
 */
public class LC349IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1={};
        int[] nums2={};
        int[] result=intersection(nums1,nums2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
    public static int[] intersection(int[] nums1,int[] nums2){
        if(nums1==null||nums1.length==0||nums2==null||nums2.length==0)return new int[0];
        Set<Integer> set=new HashSet<>();
        Set<Integer> res=new HashSet<>();

        for(Integer num:nums1)set.add(num);

        for(Integer num:nums2){
            if(set.contains(num))res.add(num);
        }

        int[] result=new int[res.size()];
        int index=0;
        for(Integer num:res){
            result[index++]=num;
        }
        return result;
    }
}
