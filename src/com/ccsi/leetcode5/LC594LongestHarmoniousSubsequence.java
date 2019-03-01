package com.ccsi.leetcode5;

import java.util.*;

public class LC594LongestHarmoniousSubsequence {
    public static void main(String[] args) {
        int[] nums={1,3,2,2,5,2,3,7};
        System.out.println(findLHS(nums));
    }
    public static int findLHS(int[] nums){
        int result=0;
        Map<Long,Integer> map=new HashMap<>();
        for(long num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for (Long key:map.keySet()) {
            if(map.containsKey(key+1)){
                result=Math.max(result,map.get(key)+map.get(key+1));
            }
        }
        return result;
    }
}
