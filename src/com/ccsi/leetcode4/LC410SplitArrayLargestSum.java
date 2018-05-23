package com.ccsi.leetcode4;

import java.util.*;

/**
 * Created by gxliu on 2018/5/20.
 */
public class LC410SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums={7,1,2,5,10,8};
        System.out.println(splicArray(nums,2));
    }
    //DP
    public static int splicArray(int[] nums,int m){
        if(nums==null||nums.length==0)return 0;
        int len=nums.length;
        int[] sums=new int[len+1]; //sums[i]表示从第0个到第i位数之和。
        int[][] dp=new int[m+1][len+1]; //dp[i][j]表示将数组中前j个数字分成i组所能得到的最小的各个子数组中最大值

        for (int i = 1; i <= len; i++) {
            sums[i]=sums[i-1]+nums[i-1];
        }
        //Arrays.fill with multidimensional array，初始化二维数组
        for (int[] array:dp) {
            Arrays.fill(array,Integer.MAX_VALUE);
        }

        dp[0][0]=0; //起始为0，没有任何数。
        for (int i = 1; i <= m; i++) { //从分为1组到分为m组，迭代计算
            for (int j = 1; j <= len; j++) { //数组中前j位分为i组subarray，一一计算
                //对这前j个数进行切割，位置k从i-1位开始
                for (int k = i-1; k < j; k++) { //关键步骤，由于只有j个数字，如果每个数字都是单独的一组，
                    // 那么最多有j组；如果将整个数组看为一个整体，那么最少有1组，所以i的范围是[1, j]，所以
                    // 我们要遍历这中间所有的情况。假如中间任意一个位置k，dp[i-1][k]表示数组中前k个数字分成
                    // i-1组所能得到的最小的各个子数组中最大值，而sums[j]-sums[k]就是后面的数字之和，我们
                    // 取二者之间的较大值，然后和dp[i][j]原有值进行对比，更新dp[i][j]为二者之中的较小值，
                    // 这样k在[1, j]的范围内扫过一遍，dp[i][j]就能更新到最小值。
                    int val=Math.max(dp[i-1][k],sums[j]-sums[k]);// 对前k个数分成i-1组，k后面为1组，共i组。
                    //找最大值。
                    dp[i][j]=Math.min(dp[i][j],val); //更新dp[i][j],是原来的大还是计算过之后的大。
                }
            }
        }
        return dp[m][len]; //我们最终返回dp[m][n]即可
    }
}
