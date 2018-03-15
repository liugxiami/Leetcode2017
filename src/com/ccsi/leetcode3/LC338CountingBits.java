package com.ccsi.leetcode3;

/**
 * Created by gxliu on 2018/3/13.
 */
public class LC338CountingBits {
    public static void main(String[] args) {
        int num=16;
        int[] res=countBits(num);
        for (int i = 0; i <= num; i++) {
            System.out.println(res[i]);
        }
    }
    //
    public static int[] countBits(int num){
        int[] result=new int[num+1];
        result[0]=0;
        for (int i = 1; i <= num; i++) {
            result[i]=result[i>>1]+(i&1);
        }
        return result;
    }
}
