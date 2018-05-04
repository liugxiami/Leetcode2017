package com.ccsi.leetcode3;

/**
 * Created by gxliu on 2018/5/3.
 */
public class LC397IntegerReplacement {
    public static void main(String[] args) {
        System.out.println(integerReplacement(7));
    }
    public static int integerReplacement(int n){
        if(n==1)return 0;
        if(n%2==0)return integerReplacement(n/2)+1;
        else {
            long num=n;
            return Math.min(integerReplacement((int)((num+1)/2)),integerReplacement((n-1)/2))+2;
        }
        //在奇数时+2，是因为一个是奇变偶数也算一次，然后/2也算一次。
    }
}
