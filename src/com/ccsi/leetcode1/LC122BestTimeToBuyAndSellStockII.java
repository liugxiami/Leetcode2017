package com.ccsi.leetcode1;

/**
 * Created by gxliu on 2017/10/29.
 */
public class LC122BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        int[] prices={1,3,5,2,6,3,5};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int delta = prices[i] - prices[i - 1];
            if (delta > 0) {
                profit += delta;
            }
        }
        return profit;
    }
}
