package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/10/7.
 */
public class LC070ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs2(10));
    }
    //method1 DP1 O(N)
    public static int climbStairs(int n){
        if(n<=0)return -1;
        if(n<=2)return 1;
        int[] cache=new int[n+1];
        cache[1]=1;
        cache[2]=1;
        for (int i = 3; i <=n; i++) {
            cache[i]=cache[i-1]+cache[i-2];
        }
        return cache[n];
    }
    //method2 DP2 O(1)
    public static int climbStairs1(int n){
        if(n<=0)return -1;
        if(n<=2)return 1;
        int a=1,b=1;
        for (int i = 3; i <=n; i++) {
            int c=a+b;
            a=b;
            b=c;
        }
        return b;
    }
    //method3 递归
    public static int climbStairs2(int n){
        if(n<=0)return -1;
        if(n<=2)return 1;
        int[] cache=new int[n+1];
        helper(n,cache);
        return cache[n];
    }
    private static int helper(int n,int[] cache){
        if(n==1) cache[1]=1;
        if(n==2) cache[2]=1;
        if(cache[n]!=0)return cache[n];
        else cache[n]=helper(n-1,cache)+helper(n-2,cache);
        return cache[n];
    }
}
