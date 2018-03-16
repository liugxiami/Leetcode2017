package com.ccsi.leetcode3;

/**
 * Created by gxliu on 2018/3/15.
 */
public class LC343IntegerBreak {
    public static void main(String[] args) {
        System.out.println(integerBreak1(10));
    }
    //给的第一个数必须分，即使是2，也要分成1+1；
    public static int integerBreak(int  n){
        if(n<2||n>=58)return 0;
        int max=0;
        for (int i = 1; i <=n/2; i++) {
            int left=helper(i);
            int right=helper(n-i);
            max=Math.max(max,left*right);
        }
        return max;
    }
    //第一次被分之后的数可以不再分了，比较自己大还是继续分的乘积大。
    private static int helper(int n){
        if(n==1)return 1;
        int max=n;
        for (int i = 1; i <= n/2; i++) {
            int left=helper(i);
            int right=helper(n-i);
            max=Math.max(max,left*right);
        }
        return max;
    }

    //DP
    public static int integerBreak1(int n){
        if(n<2||n>=58)return 0;
        int[] cache=new int[n+1];
        cache[1]=1;
        cache[2]=1;
        for (int i = 3; i <=n; i++) {
            for (int j = 1; j <i; j++) {
                cache[i]=Math.max(cache[i],Math.max(j,cache[j])*Math.max(i-j,cache[i-j]));
            }
        }
        return cache[n];
    }
}
