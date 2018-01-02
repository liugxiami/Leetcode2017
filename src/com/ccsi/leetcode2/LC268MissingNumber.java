package com.ccsi.leetcode2;

/**
 * Created by gxliu on 2018/1/1.
 */
public class LC268MissingNumber {
    public static void main(String[] args) {
        int[] nums={9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber1(nums));
    }
    //method1,用一个boolean的数组来记录存在的数字，但如果这个nums非常大，这个算法显然不行。
    public static int missingNumber(int[] nums){
        int len=nums.length;
        boolean[] existing=new boolean[len+1];

        for (int i = 0; i < len; i++) {
            existing[nums[i]]=true;
        }

        int result=0;
        for (int i = 0; i < len + 1; i++) {
            if(!existing[i])result=i;
        }

        return result;
    }
    //method2，可以求0到n的总和sum1，再求出nums所有数之和sum2，sum1-sum2就是结果。
    public static int missingNumber1(int[] nums){
        int len=nums.length;
        int expectSum=0;
        int sum=0;

        for (int i = 1; i <=len; i++) {
            expectSum+=i;
        }

        for (int i = 0; i < len; i++) {
            sum+=nums[i];
        }

        return expectSum-sum;
    }
}
