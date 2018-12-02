package com.ccsi.leetcode5;

import java.util.HashSet;
import java.util.Set;

public class LC523ContinuesSubarraySum {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(checkSubarraySum(nums,4));
    }
    //Memory Limit Exceeded
    public static boolean checkSubarraySum(int[] nums,int k){
        if(nums==null||nums.length==0)return false;
        if(nums[0]==0&&nums[1]==0)return true;//sum==0,0==0*k;
        if(k==0)return false;
        k=Math.abs(k);

        int len=nums.length;
        int[][] dp=new int[len][len];//表示i到j的和
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) { //只用了右上部，i>j的情况下，没必要再算了
                if(i==j)dp[i][j]=nums[i]; //i==j时，就是这个数自己
                else{
                    dp[i][j]=dp[i][j-1]+nums[j]; //递推公式，从i到j-1的和加上第j个数。
                    if(dp[i][j]%k==0)return true;//及时判断当前这个数是否是k的倍数，也就是取余是否为0.注意最小两个数之和
                }
            }
        }
        return false;
    }
    //set 先排除边界条件，如果nums是空的或元素小于2个，那么不会出现满足至少2个元素之和等于k的倍数。
    //如果前两个元素都是0，那么0必然都是0*k，满足条件。
    //否则，如果k==0，那必定不可能出现两个元素之和等于0的情况。
    //k有可能是负数，先转换成正数，后面好计算。
    //用一个set来保持sum，其实是sum对k取余，因为（a+b）%k==a%k+b%k。放到这题中，如果a是sum，b为当前碰到的元素，
    //那么每次都进行这样的运算，那至于为什么可以保证continuous subarray sum，还是没明白。
    public static boolean checkSubarraySum1(int[] nums,int k){
        if(nums==null||nums.length<2)return false;
        if(nums[0]==0&&nums[1]==0)return true;
        if(k==0)return false;
        k=Math.abs(k);

        int len=nums.length;
        Set<Integer> set=new HashSet<>(); //存储sum%k
        int last=0;
        for (int i = 0; i < len; i++) {
            int curr=(last+nums[i])%k;
            if(set.contains(curr)||set.contains(k-curr))return true;
            set.add(last);
            last=curr;
        }
        return false;
    }
}
