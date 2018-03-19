package com.ccsi.leetcode3;

import java.util.*;

/**
 * Created by gxliu on 2018/3/18.
 */
public class LC350IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        int[] nums1={1,2,2,1};
        int[] nums2={2,2};
        int[] result=intersect2(nums1,nums2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
    //method1:HashMap
    public static int[] intersect(int[] nums1,int[] nums2){
        if(nums1==null||nums1.length==0||nums2==null||nums2.length==0)return new int[0];

        Map<Integer,Integer> map=new HashMap<>();
        List<Integer> res=new ArrayList<>();

        for(Integer num:nums1){
            if(!map.containsKey(num))map.put(num,0);
            map.put(num,map.get(num)+1);
        }

        for(Integer num:nums2){
            if(map.containsKey(num)){
                res.add(num);
                map.put(num,map.get(num)-1);
                if(map.get(num)==0)map.remove(num);
            }
        }

        int[] result=new int[res.size()];
        int index=0;
        for(Integer num:res)result[index++]=num;

        return result;
    }
    //method2 countingsort,不能通过测试，比如存在min=Integer.MIN_VALUE;一个整数减它就溢出了，也是负数了，这数组
    //就有问题了。
    public static int[] intersect1(int[] nums1,int[] nums2){
        if(nums1==null||nums1.length==0||nums2==null||nums2.length==0)return new int[0];
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(Integer num:nums1){
            max=Math.max(max,num);
            min=Math.min(min,num);
        }
        for(Integer num:nums2){
            max=Math.max(max,num);
            min=Math.min(min,num);
        }

        int[] counter=new int[max-min+1];
        for (Integer num:nums1) {
            counter[num-min]++;
        }
        List<Integer> res=new ArrayList<>();
        for(Integer num:nums2){
            if(counter[num-min]>0){
                res.add(num);
                counter[num-min]--;
            }
        }
        int[] result=new int[res.size()];
        int index=0;
        for(Integer num:res){
            result[index++]=num;
        }
        return result;
    }
    //method3 Arrays.sort+two pointers
    public static int[] intersect2(int[] nums1,int[] nums2){
        if(nums1==null||nums1.length==0||nums2==null||nums2.length==0)return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res=new ArrayList<>();

        int index1=0;
        int index2=0;
        while(index1<nums1.length&&index2<nums2.length){
            if(nums1[index1]<nums2[index2])index1++;
            else if(nums1[index1]>nums2[index2])index2++;
            else{
                res.add(nums1[index1]);
                index1++;
                index2++;
            }
        }

        int[] result=new int[res.size()];
        int index=0;
        for(Integer num:res){
            result[index++]=num;
        }
        return result;
    }
}
