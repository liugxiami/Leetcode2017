package com.ccsi.leetcode1;

/**
 * Created by gxliu on 2017/10/29.
 */
public class LC121BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices={7,6,5,4,3,2};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices){
        if(prices==null||prices.length==0)return 0;
        int lowest=prices[0];
        int profit=0;

        for (int i = 1; i < prices.length; i++) {
            if(prices[i]<lowest){
                lowest=prices[i];
            }else{
                profit=Math.max(profit,prices[i]-lowest);
            }
        }
        return profit;
    }
}
