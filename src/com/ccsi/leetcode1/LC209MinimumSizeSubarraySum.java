package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/12/8.
 */
public class LC209MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] num={2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,num));
    }
    //O[N] 双指针，方法同Maximum Subarray
    public static int minSubArrayLen(int s,int[] num){
        if(s<0||num==null||num.length==0)return 0;
        int len=num.length;

        int sum=0;
        int minSize=len+1;
        int left=0,right=0;
        while (right<len) {
            while(right<len&&sum<s){
                sum+=num[right++];
            }
            while(sum>=s){
                minSize=Math.min(minSize,right-left);//因为right已经++，其实际指向了末尾的下一个。
                sum-=num[left++];
            }
        }
        return minSize==len+1?0:minSize;
    }
}
