package com.ccsi.leetcode3;

/**
 * Created by gxliu on 2018/2/21.
 */
public class LC322CoinChange {
    public static void main(String[] args) {
        int[] coins={1,2,5};
        System.out.println(coinChange(coins,11));
    }
    public static int coinChange(int[] coins,int amount){
        if(coins==null||coins.length==0||amount<0)return -1;
        int[] cache=new int[amount+1];
        cache[0]=0;
        for (int i = 1; i <=amount; i++) {
            int curr=Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if(i-coins[j]>=0&&cache[i-coins[j]]!=Integer.MAX_VALUE){
                    curr=Math.min(curr,cache[i-coins[j]]+1);
                }
            }
            cache[i]=curr;
        }
        return cache[amount]==Integer.MAX_VALUE?-1:cache[amount];
    }
}
