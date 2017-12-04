package com.ccsi.leetcode1;

/**
 * Created by gxliu on 2017/12/3.
 */
public class LC191NumberOf1bBits {
    public static void main(String[] args) {
        System.out.println(hammingWeight1(11));
    }
    public static int hammingWeight(int n){
        int count=0;
        while(n!=0){
            if((n&1)==1)count++;
            n>>>=1;
        }
        return count;
    }
    //method2,n&(n-1)，更快
    /*
    使用n&(n-1)的方法
    假使 n =0x110101
                n             n-1           n&(n-1)
    step1:   110101          110100          110100
    step2:   110100          110011          110000
    step3:   110000          101111          100000
    step4:   100000          011111          000000
    发现有几个1，就循环几次n&(n-1)得到0，明显较于上者运行效率更高些。
     */
    public static int hammingWeight1(int n){
        int count=0;
        while(n!=0){
            n&=(n-1);
            count++;
        }
        return count;
    }
}
