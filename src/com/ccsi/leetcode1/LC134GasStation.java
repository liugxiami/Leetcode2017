package com.ccsi.leetcode1;

/**
 * Created by gxliu on 2017/11/12.
 */
public class LC134GasStation {
    public static int canCompleteCircuit(int[] gas,int[] cost){
        if(gas.length!=cost.length)return -1;
        int delta=0;
        for (int i = 0; i < gas.length; i++) {
            delta+=gas[i]-cost[i];
        }

        if(delta<0)return -1;

        delta=0;
        int start=0;

        for (int i = 0; i < gas.length; i++) {
            delta+=gas[i]-cost[i];
            if(delta<0){
                delta=0;
                start=i+1;
            }
        }
        return start;
    }
}
