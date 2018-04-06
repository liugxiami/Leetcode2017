package com.ccsi.leetcode3;

import java.util.*;

/**
 * Created by gxliu on 2018/4/4.
 */
public class LC373FindKPairsWithSmallestSums {
    public static void main(String[] args) {
        int[] nums1={1,3,11};
        int[] nums2={2,4,6};
        List<int[]> res=kSmallestPairs(nums1,nums2,3);
        res.forEach(x-> System.out.printf("%d and %d\n",x[0],x[1]));
    }
    public static List<int[]> kSmallestPairs(int[] nums1,int[] nums2,int k){
        List<int[]> result=new ArrayList<>();
        if(nums1==null||nums1.length==0||nums2==null||nums2.length==0)return result;
        int len1=nums1.length;
        int len2=nums2.length;

        //分别取两数组的前k个数进行组合，因为这两个数组是已经排好序的，那么最小的前k个组合必定在这里面。
        for (int i = 0; i < Math.min(k, len1); i++) {
            for (int j = 0; j < Math.min(k, len2); j++) {
                int[] temp={nums1[i],nums2[j]};
                result.add(temp);
            }
        }
        //对这些组合进行排序，按各组的和来排序，传一个comparator进去
        Collections.sort(result, (a,b)->(a[0]+a[1])-(b[0]+b[1]));
        //只留前k个组合，其他的删掉。
        while(result.size()>k){
            result.remove(result.size()-1);
        }

        return result;
    }
}
