package com.ccsi.leetcode1;

/**
 * Created by gxliu on 2017/11/13.
 */
public class LC137SingleNumberII {
    public static void main(String[] args) {
        int[] nums={1,2,3,1,2,1,2,3,3,4};
        System.out.println(singleNumber(nums));
    }
    //method1 用一个32个元素的数组，用来保存nums中给个数的二进制为上，每一位上是1的个数。
    public static int singleNumber(int[] nums){
        int[] arr=new int[32];
        int result=0;
        for(int num:nums){
            int index=0;
            while(num!=0){
                if(num%2==1)arr[index]++;
                index++;
                num/=2;
            }
        }

        for (int i = 0; i < 32; i++) {
            result+=(arr[i]%3)<<i;
        }
        return result;
    }
    //method2，也是对每一个num的二进制位进行统计，但省了数组来缓存，更高效。
    public static int singleNumber1(int[] nums){
        int result=0;
        for (int i = 0; i < 32; i++) {
            int count=0,bit=1<<i;
            for(int num:nums){
                if((num&bit)!=0)count++;  //第一次出错了，用了==1。应该是！=0，因为确实不是1，是2的n次方。
            }

            if(count%3!=0)result|=bit;
        }
        return result;
    }
}
