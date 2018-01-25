package com.ccsi.leetcode2;

/**
 * Created by gxliu on 2018/1/20.
 */
public class LC309BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        int[] prices={1,2,3,0,2};
        System.out.println(maxProfitDP(prices));
    }
    //method1 greedy,这个方法不行，如果是连续两天都是价格在下降，那么问题就来了，这个prepreDelta就不是我们想要的最后一对上升了。
    public static int maxProfit(int[] prices){
        if(prices==null||prices.length<2)return 0;
        int prepreDelta=0;
        int preDelta=0;
        int profit=0;

        int pre=prices[0];
        for (int i = 1; i < prices.length; i++) {
            int delta=prices[i]-pre;
            if(delta>0){
                if(preDelta<0){
                    profit-=prepreDelta;
                    profit+=Math.max(delta,prepreDelta);
                }else{
                    profit+=delta;
                }
            }
            prepreDelta=preDelta;
            preDelta=delta;
            pre=prices[i];
        }
        return profit;
    }
    //method2 DP，还是要用DP,用两数组来记录当前的最大利润
    public static int maxProfitDP(int[] prices){
        if(prices==null||prices.length<2)return 0;
        int len=prices.length;

        int[] buy=new int[len]; //第i天持有股票时，当天已有的最大利润
        int[] sell=new int[len]; //第i天不持有股票，这时获得了的最大利润。
        //初始化
        buy[0]=-prices[0]; //第一买进股票，这时是把钱投了出去，付出
        sell[0]=0; //不买进的化，利润为0

        for (int i = 1; i < len; i++) {
            sell[i]=Math.max(sell[i-1],buy[i-1]+prices[i]); //这天不持有股票，那么有两种情况，一是手上就没股票，没发卖出，
            // 那就是利润和昨天一样；第二种情况是，手上有股票可以卖出，那就今天套现。
            buy[i]=Math.max(buy[i-1],(i-2>=0?sell[i-2]:0)-prices[i]); //今天持有股票，还是两种情况，一是手上有股票，继续
            //持有，利润和昨天一样；而是前天（因为题目要求cooldown）将股票卖出了，今天可以买进。
        }
        return sell[len-1]; //返回最后一天，手上没有股票时的利润。
    }
}
