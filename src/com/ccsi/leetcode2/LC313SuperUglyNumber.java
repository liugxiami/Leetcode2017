package com.ccsi.leetcode2;

import java.util.Arrays;

/**
 * Created by gxliu on 2018/1/27.
 */
public class LC313SuperUglyNumber {
    public static void main(String[] args) {
        int[] primes={3,5,7,11,19,23,29,41,43,47};
        System.out.println(nthSuperUlgyNumber(15,primes));
    }
    //方法同前面ugly num II类似，用merger sorted list相同的方法。有几个primes就有几条list。
    public static int nthSuperUlgyNumber(int n,int[] primes){
        if(primes==null||primes.length==0||n==1)return 1;
        int len=primes.length;
        int[] cache=new int[n]; //存储ugly Numbers
        int[] primeIndex=new int[len];//相应的prime 的index
        cache[0]=1;

        for (int i = 1; i < n; i++) {
            int min=Integer.MAX_VALUE;
            for (int j = 0; j < len; j++) {
                min=Math.min(min,cache[primeIndex[j]]*primes[j]);
            }

            for (int j = 0; j < len; j++) {
                // 所有符合条件的，都需增加对应prime index, 避免重复
                if(min==cache[primeIndex[j]]*primes[j]){
                    primeIndex[j]++;
                }
            }
            cache[i]=min;
            System.out.println(min);
        }
        return cache[n-1];
    }
}
