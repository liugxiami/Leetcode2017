package com.ccsi.leetcode1;

/**
 * Created by gxliu on 2017/12/3.
 */
public class LC190ReverseBits {
    public static void main(String[] args) {
        System.out.println(reverseBits1(43261596));
    }
    public static int reverseBits(int n){
        int result=0;
        for (int i = 0; i < 32; i++) {
            int flat=n&(1<<i);
            flat>>=i;
            if(flat==1){
                result|=(1<<(31-i));
            }
        }
        return result;
    }
    //method2
    public static int reverseBits1(int n){
        int result=0;
        int i=0;
        while (n!=0) {
            if((n&1)==1){
                result|=(1<<(31-i));
            }
            n>>>=1;// 必须进行无符号位移
            i++;
        }
        return result;
    }
}
