package com.ccsi.leetcode3;

import java.util.*;

/**
 * Created by gxliu on 2018/4/10.
 */
public class LC376WiggleSubsequence {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7,8,9};
        System.out.println(wiggleMaxLength1(nums));
    }
    //method1
    public static int wiggleMaxLength(int[] nums){
        if(nums==null||nums.length==0)return 0;
        int len=nums.length;
        int[] cache=new int[len];
        Arrays.fill(cache,1);
        boolean increase=false;
        for (int i = 1; i < len; i++) {
            int delta=nums[i]-nums[i-1];
            if(cache[i-1]==1){
                if(delta==0)continue;
                if(delta>0){
                    increase=true;
                }else increase=false;

                cache[i]=cache[i-1]+1;
            }else{
                if(delta>0&&!increase||delta<0&&increase){
                    cache[i]=cache[i-1]+1;
                    increase=!increase;
                }else{
                    cache[i]=cache[i-1];
                }
            }
        }
        return cache[len-1];
    }
    //method2 贪心的算法
    public static int wiggleMaxLength1(int[] nums){
        if(nums==null||nums.length==0)return 0;
        if(nums.length==1)return 1;
        int len=nums.length;
        int flag=0;//前一对之差
        int count=nums.length;//开始假设是数组长度
        for (int i = 1; i < len; i++) {
            int delta=nums[i]-nums[i-1]; //当前这一对的差值
            if(delta==0)count--; //如果是相同的，直接-1；
            else if(delta*flag>0)count--;//如果当前差值与前面一对的差值同正或同负，那么也-1；
            else flag=delta;//否则，wiggle num算数，但要将当前的差值交给flag。
        }
        return count;
    }
}
