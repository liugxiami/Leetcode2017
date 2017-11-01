package com.ccsi.leetcode1;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by gxliu on 2017/10/30.
 */
public class LC123BestTimeToBuyandSellStockIII {
    public static void main(String[] args) {
        int[] prices={3,5,1,7,6,5,4,9,3,20};
        System.out.println(maxProfitDP(prices));
    }
    //method1,依次扫描，如果当前比前一天的价格低了，那么对前面的最低价和最高价求利润，并存入priorityQueue，
    //并更新最低和最高价，如果是上升，更新最高价。最后将priorityQueue里面的两个最高价给吐出来相加。
    //这个方法计算出的结果不对。
    public static int maxProfit(int[] prices){
        if(prices==null||prices.length==0)return 0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int low=prices[0];
        int high=prices[0];
        int profit=0;

        for (int i = 1; i < prices.length; i++) {
            if(prices[i]<prices[i-1]||i==prices.length-1){
                profit=high-low;

                if(i==prices.length-1){
                    profit=prices[i]-low;
                }
                pq.offer(profit);

                low=prices[i];
                high=prices[i];
            }else{
                high=prices[i];
            }
        }

        int max=0;
        int count=2;
        while(!pq.isEmpty()&&count-->0){
            max+=pq.poll();
        }
        return max;
    }
    //method2：将数组[0.N-1]分成[0，i]和[i+1，N-1]两部分，分别求最高利润，i从1到n-1，将左边和右边的
    //利润分别存在left[]和right[]数组里面，将left[i]+right[i]最大的返回就好了。
    public static int maxProfit1(int[] prices){
        if(prices==null||prices.length==0)return 0;
        int len=prices.length;

        int[] left=new int[len];
        int[] right=new int[len];

        int leftLowest=prices[0];
        //left[0]=0;
        for (int i = 1; i < len; i++) {
            left[i]=Math.max(left[i-1],prices[i]-leftLowest);
            leftLowest=Math.min(leftLowest,prices[i]);
        }

        int rightHighest=prices[len-1];
        //right[len-1]=0;
        for (int i = len-2; i >=0; i--) {
            right[i]=Math.max(right[i+1],rightHighest-prices[i]);
            rightHighest=Math.max(rightHighest,prices[i]);
        }

        int max=0;
        for (int i = 0; i < len; i++) {
            max=Math.max(max,left[i]+right[i]);
        }

        return max;
    }
    //method3：DP
    public static int maxProfitDP(int[] prices){
        return max(prices,2);
    }

    private static int max(int[] prices,int k){
        if(prices==null||prices.length==0)return 0;
        int len=prices.length;

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
}
