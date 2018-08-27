package com.ccsi.leetcode4;

public class LC461HammingDistance {
    public static void main(String[] args) {
        System.out.println(hammingDistance(1,4));
    }
    //求两个数相应的二进制位中不同的位数个数，先对两个数求异或（不相同为1，相同为0），那么再求这个数里面有多少个1就是了。
    public static int hammingDistance(int x,int y){
        int z=x^y;
        int count=0;
        while(z!=0){ //求一个数中有多少个1的方法很多，这只是其中一种。
            count++;
            z=z&(z-1); //用求与来做。
        }
        return count;
    }
}
