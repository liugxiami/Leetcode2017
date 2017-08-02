package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/8/1.
 */
public class LC029DivideTwoIntegers {
    public static void main(String[] args) {
        System.out.println(divide1(15,3));
    }
    //最简单的想法就是使劲的减除数，直到小于0，计数减的次数，这个个次数就是结果。
    // 但这显然不是最好的方法，如果这个数特别但，而除数特别小，那就需要消耗太多的时间。
    public static int divide(int dividend,int divisor){
        if(dividend==0)return 0;
        if(divisor==0)return dividend>0?Integer.MAX_VALUE:Integer.MIN_VALUE;

        int flag=1;
        if(dividend<0&&divisor<0){
            dividend=-dividend;
            divisor=-divisor;
            flag=1;
        }
        if(dividend<0){
            dividend=-dividend;
            flag=-1;
        }
        if(divisor<0){
            divisor=-divisor;
            flag=-1;
        }

        int count=0;
        while(dividend-divisor>=0){
            count++;
            dividend-=divisor;
        }

        return flag==-1?-count:count;
    }
    //利用bit manipulation
    public static int divide1(int dividend,int divisor){
        if(dividend==0)return 0;
        if(divisor==0)return dividend>0?Integer.MAX_VALUE:Integer.MIN_VALUE;
        if(dividend==Integer.MIN_VALUE&&divisor==-1)return Integer.MAX_VALUE;
        if(divisor==1)return dividend;

        int flag=((dividend>0)^(divisor>0))?-1:1;
        long dvd=Math.abs((long)dividend);
        long dvs=Math.abs((long)divisor);

        int result=0;
        while(dvd>=dvs){
            int shift=0;
            while(dvd>=(dvs<<shift)){
                shift++;
            }
            dvd-=dvs<<(shift-1);
            result+=1<<(shift-1);
        }

        return flag>0?result:-result;
    }
}
