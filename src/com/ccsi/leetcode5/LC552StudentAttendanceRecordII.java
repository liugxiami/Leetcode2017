package com.ccsi.leetcode5;

import java.util.*;

public class LC552StudentAttendanceRecordII {
    public static void main(String[] args) {
        System.out.println(checkRecord(3));
    }
    /*
    这题只要求最后可以获得奖励的总数，不是所有可以活得奖励的可能性的所有组合，所以用DP比BT更好，会快一些。
    DP的话就要弄清楚递推公式
    DP[i]表示总长度位i时，其可获得奖励的最大次数。因为每一位上都有可能时‘A’,'L','P',如果不考虑意外情况，那么总的次数就是3^n.
    但题目有要求，如果A出现多于一次就没奖励了，L连续出现2次以上也没有奖励。那么我们就要分开来看，
    首先，根据A在DP里有没有出现分两种情况，一是没出现过，二是出现过1次，三是出现过多次（这不重要了，已经2次以上就没奖励了，相当与0）
    1.A没有出现的情况：
        又再分两种情况
        1）以P为结尾的情况
        DP[i]=DP[i-1]
        2）以L为结尾的情况
        DP[i]=DP[i-1]-DP[i-4]（...PLLL要排除）
    2.A出现一次的情况：
        假如A出现的位置为i位 [...,i-1]A[i+1,...,n]（A的前面有i-1一个元素，A的后面有n-i个元素，总共是n个元素，那么其总次数就是前面
        的i-1个元素，注是无A的情况，在DP里面已经计算过了，是DP[i-1]；后面是n-i个元素，也是无A的情况，也计算过了，是DP[n-i]，前后的乘积）
        DP[i]=DP[i-1]*DP[n-i]
    3.A出现两次或两次以上的情况（不会记录在DP里面）
     */
    private static long M=1000000007;
    public static int checkRecord(int n){
        //声明一个dp数组
        long[] dp=new long[n<=3?4:n+1]; //考虑到前面要减去i-4的plll的情况，去长度至少位4，否则就是n+1
        //初始化前面几张情况。没有A的情况下
        dp[0]=1;
        dp[1]=2; //有p和l两种情况
        dp[2]=4; //有pp，pl，lp，ll四种情况
        dp[3]=7; //有ppp，ppl，pll，plp,lpp,llp,lpl(2^3-1,去掉lll的情况)
        for (int i = 4; i < n; i++) {
            dp[i]=(dp[i-1]*2)%M+(M-dp[i-4])%M; //将没有A的两种情况加起来。随时取M
        }
        long sum=dp[n]%M; //没有A的情况的总数
        //还要加上有A的情况，这个A只有一个，其出现的位置可能在1到n的任何一个位置上
        for (int i = 1; i <= n; i++) { //A出现在第i为上
            sum+=(dp[i-1]*dp[n-i])%M;
        }
        return (int)(sum%M);
    }

}
