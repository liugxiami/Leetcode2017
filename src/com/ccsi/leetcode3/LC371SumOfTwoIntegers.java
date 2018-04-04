package com.ccsi.leetcode3;

/**
 * Created by gxliu on 2018/4/3.
 */
public class LC371SumOfTwoIntegers {
    public static void main(String[] args) {
        System.out.println(getSum(3,5));
    }
    //思路，用二进制来计算，两数相加，二进制上不同的话，直接就加上，用^来做；如果二进制上相同的话，用&先获取
    //然后乘以2，也就是向左移动一位就可以了，递归相加就可以了。结束条件是其中一个为0.
    public static int getSum(int a,int b){
        if(b==0)return a;
        int sum=a^b; //^在二进制位上不相同的漏下来
        int flag=(a&b)<<1;//&二进制上相同的漏下来，因为是相加，相当于乘以2
        return getSum(sum,flag); //递归计算
    }

    public static int getSum1(int a,int b){
        return a+b;
    }
}
