package com.ccsi.leetcode2;

/**
 * Created by gxliu on 2017/12/29.
 */
public class LC263UglyNumber {
    public static void main(String[] args) {
        System.out.println(isUgly2(10));
    }
    //method1
    public static boolean isUgly(int num){
        if(num<1)return false;
        int[] primes={5,3,2};
        for (int i = 0; i < 3; i++) {
            int prime=primes[i];
            while(true){
                if(num==1)return true;
                if((num%prime)==0)num/=prime;
                else break;
            }
        }
        return false;
    }
    //method2
    public static boolean isUgly1(int num){
        if(num<1)return false;

        while(num%5==0)num/=5;
        while(num%3==0)num/=3;
        while(num%2==0)num/=2;

        return num==1;
    }
    //method3 对1改写一下
    public static boolean isUgly2(int num){
        if(num<1)return false;
        int[] primes={5,3,2};
        for (int i = 0; i < 3; i++) {
            while(num%primes[i]==0)num/=primes[i];
        }
        return num==1;
    }

}
