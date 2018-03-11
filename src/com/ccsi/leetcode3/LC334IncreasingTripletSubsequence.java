package com.ccsi.leetcode3;

/**
 * Created by gxliu on 2018/3/11.
 */
public class LC334IncreasingTripletSubsequence {
    public static void main(String[] args) {
        int[] nums={8,3,5,1,6};
        System.out.println(increasingTriplet3(nums));
    }
    //method1 DP
    public static boolean increasingTriplet(int[] nums){
        if(nums==null||nums.length<3)return false;
        int len=nums.length;
        int[][] cache=new int[len][len];

        cache[0][0]=1;

        for (int row = 0; row < len; row++) {
            for (int col = 0; col < len; col++) {
                if(row==col)cache[row][col]=1;

                if(row==0||nums[col]>nums[row])cache[row][col]=cache[row][row]+1;
                else cache[row][col]=cache[row-1][col];

                if(cache[row][col]>=3)return true;
            }
        }
        return false;
    }
    public static boolean increasingTriplet1(int[] nums){
        if(nums==null||nums.length<3)return false;
        int len=nums.length;
        int[] pre=new int[len];

        pre[0]=1;

        for (int i = 1; i < len; i++) {
            if(nums[i]>nums[0])pre[i]=pre[0]+1;
        }

        for (int row = 1; row < len; row++) {
            int[] curr=new int[len];
            for (int col = 0; col < len; col++) {
                if(row==col)pre[col]=1;

                if(nums[col]>nums[row])curr[col]=pre[row]+1;
                else curr[col]=pre[col];

                if(curr[col]>=3)return true;
            }
        }
        return false;
    }
    //method2 双指针，一个保存最小的，一个保存第二小，如果在出现一个比第二小的话，那么存在，否则不存在。
    public static boolean increasingTriplet2(int[] nums){
        if(nums==null||nums.length<3)return false;
        int len=nums.length;

        int smallest=Integer.MAX_VALUE;
        int second=Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            if(nums[i]>second)return true; //如果发现某个值大于第二小的值，那么说明存在题目要求的三个递增子序列。

            if(nums[i]<smallest)smallest=nums[i]; //让smallest始终保存最小值

            if(nums[i]>smallest&&nums[i]<second)second=nums[i];//second保存第二小的值
        }
        return false;
    }
    //method3
    public static boolean increasingTriplet3(int[] nums){
        if(nums==null||nums.length<3)return false;
        int len=nums.length;
        int[] forward=new int[len]; //forward[i]表示[0, i]之间最小的数
        int[] backward=new int[len]; //backward[i]表示[i, n-1]之间最大的数

        for (int i = 0; i < len; i++) {
            if(i==0)forward[i]=nums[i];
            else forward[i]=Math.min(forward[i-1],nums[i]);
        }

        for (int i = len-1; i>=0 ; i--) {
            if(i==len-1)backward[i]=nums[i];
            else backward[i]=Math.max(backward[i+1],nums[i]);
        }

        for (int i = 0; i < len; i++) {
            if(nums[i]>forward[i]&&nums[i]<backward[i])return true;
            //对于任意一个位置i，如果满足 forward[i] < nums[i] < backward[i],则找到了。
        }
        return false;
    }
}
