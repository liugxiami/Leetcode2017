package com.ccsi.leetcode4;

/**
 * Created by gxliu on 2018/7/8.
 */
public class LC441ArrangingCoins {
    public static void main(String[] args) {
        System.out.println(arrangeCoins(1804289383));
    }
    //method 1, binary search based on (1+k)*k/2<=n
    public static int arrangeCoins(int n){
        if(n<1)return 0;
        if(n==1)return 1;
        int left=1,right=n;
        long m=(long)n*2;
        while(left<=right){
            int mid=(right-left)/2+left;
            long sq=(long)mid*mid+mid;
            if(sq==m)return mid;
            else if(sq>m)right=mid-1;
            else left=mid+1;
        }
        return right;
    }
    //math
    public static int arrangeCoins1(int n){
        /*
        (1+k)*k/2=n
        k*k+k=2n
        k*k+k+0.25=2n+0.25
        (k+0.5)^2=2n+0.25
        k+0.5=Math.sqrt(2n+0.25)
        k=Math.sqrt(2n+0.25)-0.5
         */
        return (int)(Math.sqrt(2*(long)n+0.25)-0.5);
    }
}
