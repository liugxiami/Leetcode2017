package com.ccsi.leetcode3;

/**
 * Created by gxliu on 2018/2/6.
 */
public class LC319BulbSwitcher {
    public static void main(String[] args) {
        System.out.println(bulbSwitch1(100));
    }
    public static int bulbSwitch(int n){
        boolean[] bulb=new boolean[n+1];
        for (int round = 1; round <= n; round++) {
            for (int b = 1; b <= n ; b++) {
                if(b%round==0) {
                    bulb[b]=!bulb[b];
                }
            }
        }
        int count=0;
        for (int i = 1; i <= n; i++) {

            if(bulb[i]){
                System.out.println(i);
                count++;
            }
        }
        return count;
    }
    public static int bulbSwitch1(int n){
        return (int)Math.sqrt(n);
    }
}
