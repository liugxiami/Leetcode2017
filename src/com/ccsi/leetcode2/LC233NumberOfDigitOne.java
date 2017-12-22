package com.ccsi.leetcode2;

/**
 * Created by gxliu on 2017/12/21.
 */
public class LC233NumberOfDigitOne {
    //Brute force
    public static int countDigitOne(int n){
        if(n<1)return 0;
        int sum=0;
        for (int i = 0; i <= n; i++) {
            sum+=countOnes(i);
        }
        return sum;
    }
    private static int countOnes(int n){
        if(n<1)return 0;
        int count=0;
        while(n>0){
            if(n%10==1)count++;
            n/=10;
        }
        return count;
    }
    //method2 递归好理解一些
    public static int countDigitOne1(int n){
        if(n<=0)return 0;
        if(n<=9)return 1;

        String s=String.valueOf(n);
        int len=s.length();
        int m=(int)Math.pow(10,len-1);

        if(n>=2*m)return (n/m)*countDigitOne1(m-1)+countDigitOne1(n%m)+m;
        else return countDigitOne1(m-1)+countDigitOne1(n%m)+n%m+1;

    }
    public static void main(String[] args) {
        System.out.println(countDigitOne1(113));
    }
}
