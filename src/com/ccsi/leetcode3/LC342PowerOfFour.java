package com.ccsi.leetcode3;

/**
 * Created by gxliu on 2018/3/15.
 */
public class LC342PowerOfFour {
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(8));
    }
    //4的n次方的规律是：二进制奇数位上是1，并且只有一个1；只有一个1的情况，可以用2的n次方的方法，就是用这个数对比这个
    //数小1的数取与等于0；但这个1必须在奇数位上，那么我们用一个filter来排除偶数位上的1，这个filter长成这样：01010101.
    //奇数位上的可以漏下来，偶数位的不行，代码如下。
    public static boolean isPowerOfFour(int num){
        return num>0&&(num&(num-1))==0&&(num&(0x55555555))!=0;
    }
}
