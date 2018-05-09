package com.ccsi.leetcode3;

import java.util.*;

/**
 * Created by gxliu on 2018/5/7.
 */
public class LC398RandomPickIndex {
    public static void main(String[] args) {
        int[] nums={1,2,3,3,3};
        LC398RandomPickIndex solution=new LC398RandomPickIndex(nums);
        System.out.println(solution.pick(2));
    }
    private Map<Integer, List<Integer>> map;
    public LC398RandomPickIndex(int[] nums){
        if(nums==null||nums.length==0)return;
        map=new HashMap<>();

        int len=nums.length;
        for (int i = 0; i < len; i++) {
            if(!map.containsKey(nums[i])){
                List<Integer> temp=new ArrayList<>();
                map.put(nums[i],temp);
            }
            map.get(nums[i]).add(i);
        }
    }
    public int pick(int target){
        if(!map.containsKey(target))return -1;
        List<Integer> list=map.get(target);
        int size=list.size();
        if(size==1)return list.get(0);

        int temp=new Random().nextInt(list.size());
        return list.get(temp);
    }
}
