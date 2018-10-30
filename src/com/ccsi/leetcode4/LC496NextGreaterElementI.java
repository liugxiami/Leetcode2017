package com.ccsi.leetcode4;

import java.util.*;

public class LC496NextGreaterElementI {
    public static void main(String[] args) {
        int[] nums1={2,4};
        int[] nums2={1,2,3,4};
        int[] result=nextGreaterElement(nums1,nums2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
    public static int[] nextGreaterElement(int[] nums1,int[] nums2){
        Map<Integer,Integer> map=new HashMap<>();
        Stack<Integer> stack=new Stack<>();
        int[] result=new int[nums1.length];

        for (int i = 0; i < nums2.length; i++) {
            while(!stack.isEmpty()&&stack.peek()<nums2[i])map.put(stack.pop(),nums2[i]);
            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i]=map.getOrDefault(nums1[i],-1);
        }

        return result;
    }
}
