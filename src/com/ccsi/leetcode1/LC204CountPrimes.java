package com.ccsi.leetcode1;

import java.util.Arrays;

/**
 * Created by gxliu on 2017/12/6.
 */
public class LC204CountPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes(2));
    }
    public static int countPrimes(int n){
        if(n<2)return 0;
        boolean[] isPrime=new boolean[n+1];
        for (int i = 2; i < n; i++) {
            isPrime[i]=true;
        }

        for (int i = 2; i <n; i++) {
            if(!isPrime[i])continue;

            for (int j = i; j*i <n ; j++) {
                isPrime[j*i]=false;
            }
        }

        int count=0;
        for (int i = 2; i <n; i++) {
            if(isPrime[i]){
                System.out.println(i);
                count++;
            }
        }

        return count;
    }
}
