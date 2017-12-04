package com.ccsi.leetcode1;

/**
 * Created by gxliu on 2017/12/3.
 */
public class LC188BestTimeToBuyAndSellStockIV {
    public static void main(String[] args) {
        int[] prices={1,2,3,2,1,5,7,3,4};
        System.out.println(maxProfit(3,prices));
    }
    public static int maxProfit(int k,int[] prices){
        if(prices==null||prices.length<2)return 0;
        int len=prices.length;
        if(k>=len)return maxProfitDirectSolved(prices);

        int[][] local=new int[len][k+1];
        int[][] global=new int[len][k+1];

        for (int i = 1; i < len; i++) {
            int diff=prices[i]-prices[i-1];
            for (int j = 1; j <= k; j++) {
                local[i][j]=Math.max(global[i-1][j-1]+Math.max(0,diff),local[i-1][j]+diff);
                global[i][j]=Math.max(global[i-1][j],local[i][j]);
            }
        }

        return global[len-1][k];
    }

    private static int maxProfitDirectSolved(int[] prices){
        int max=0;
        for (int i = 1; i < prices.length; i++) {
            int diff=prices[i]-prices[i-1];
            if(diff>0)max+=diff;
        }
        return max;
    }
}
