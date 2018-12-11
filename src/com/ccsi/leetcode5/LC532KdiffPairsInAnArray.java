package com.ccsi.leetcode5;

import java.util.*;

public class LC532KdiffPairsInAnArray {
    public static void main(String[] args) {
        int[] nums={1,3,1,4,5};
        System.out.println(findPairs(nums,0));
    }
    public static int findPairs(int[] nums,int k){
        if(nums==null||nums.length<2)return 0;
        Map<Integer,Integer> map=new HashMap<>();//key--num,value--frequency,for k==0
        for (int num:nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int count=0;
        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
            //如果k==0，那么找有多少个数是出现了多于2次的就行了
            if(k==0){
                if(entry.getValue()>=2)count++;
            }else{ //否则的话就看map是否包含（当前数+k）也在，在的话，那么这两个数的相差绝对值就是k，算一个。这里
                //没有算相减的情况，否则出现重复。
                if(map.containsKey(entry.getKey()+k))count++;
            }
        }
        return count;
    }
}
