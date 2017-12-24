package com.ccsi.leetcode2;

import java.util.*;

/**
 * Created by gxliu on 2017/12/23.
 */
public class LC238ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        int[] res=productExceptSelf1(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
    //最直接的方法，就是想将所有的乘起来，然后用这个总乘积去除以相应位置上的那个数得到结果。
    public static int[] productExceptSelf(int[] nums){
        if(nums==null||nums.length==0)return null;
        int len=nums.length;

        long total=1;
        for (int i = 0; i < len; i++) {
            total*=(long)nums[i];
        }
        //不符合题目要求，这里有除法了。
        int[] result=new int[len];
        for (int i = 0; i < len; i++) {
            result[i]=(int)(total/nums[i]);
        }
        return result;
    }
    public static int[] productExceptSelf1(int[] nums){
        if(nums==null||nums.length==0)return null;
        int len=nums.length;

        int[] forward=new int[len];
        int[] backward=new int[len];

        Arrays.fill(forward,1);
        Arrays.fill(backward,1);

        for (int i = 1; i < len; i++) {
            forward[i]=forward[i-1]*nums[i-1]; //将index之前的所有数的乘积放在index这个数组里面
        }

        for (int i = len-2; i >=0; i--) {
            backward[i]=backward[i+1]*nums[i+1];//将index之后所有数的乘积放在index这个数组里面
        }

        int[] result=new int[len];
        for (int i = 0; i < len; i++) {
            result[i]=forward[i]*backward[i]; //将index这个数之前的所有数的乘积 * 这个index之后所有数的乘积放入结果集。
        }
        return result;
    }
}
