package com.ccsi.leetcode5;

import java.util.*;

public class LC525ContiguousArray {
    public static void main(String[] args) {
        int[] nums={0,1,0};
        System.out.println(findMaxLength(nums));
    }
    public static int findMaxLength(int[] nums){
        if(nums==null||nums.length==0)return 0;
        Map<Integer,Integer> map=new HashMap<>();//key---count, value---position
        int max=0;
        int count=0;
        map.put(0,0);//类似于dummyhead，保证最最前面是0，后面在碰到0时，可以计算长度
        for (int i = 0; i < nums.length; i++) {
            count+=nums[i]==1?1:-1;
            if(map.containsKey(count)){
                max=Math.max(max,i+1-map.get(count));//注意要+1
            }else map.put(count,i+1); //其实后面的position相当于数组index+1；用else保证不覆盖，这样就可以找
            //最长长度，因为第一次出现肯定比第二第三次出现与最后一次出现的差值大。
        }
        return max;
    }
}
