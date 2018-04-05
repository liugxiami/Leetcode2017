package com.ccsi.leetcode3;

/**
 * Created by gxliu on 2018/4/4.
 */
public class LC372SuperPow {
    public static void main(String[] args) {
        int[] b={2,0,0};
        System.out.println(superPow(2147483647,b));
        //System.out.println(Math.pow(2,20)%1337);
    }
    //同前的power题，divide and conquer
    public static int superPow(int a,int[] b){
        if(b==null||b.length==0)return -1;
        if(isBZero(b))return 1; //指数为0时，任何正整数的0次方都是1.

        a%=1337;
        int len=b.length;
        boolean isEven=false;
        if(b[len-1]%2==0)isEven=true; //数组最后一个元素决定奇偶性。

        divide(b,2); //一半一半的计算。

        int result=superPow(a,b);
        result=result%1337; //及时mod
        result*=result;
        result=result%1337;

        if(!isEven){
            result*=a; //如果是奇数的话，那还得再乘以a。
            result%=1337;
        }
        return result;
    }
    //判断是否为0，0的情况是数组中所有的元素都为0.
    private static boolean isBZero(int[] b){
        for(Integer num:b){
            if(num!=0)return false;
        }
        return true;
    }
    //这个辅助函数是类似于二分法中的除以2.从高位开始，除以y，结果保存下来，余数带到低位去。
    private static void divide(int[] b,int y){
        int carryOver=0;
        for (int i = 0; i < b.length; i++) {
            b[i]+=carryOver*10;
            carryOver=b[i]%y;
            b[i]/=y;
        }
    }
}
