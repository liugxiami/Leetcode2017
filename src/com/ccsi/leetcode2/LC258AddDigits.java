package com.ccsi.leetcode2;

/**
 * Created by gxliu on 2017/12/28.
 */
public class LC258AddDigits {
    public static void main(String[] args) {
        System.out.println(addDigits1(38));
    }
    //method1 loop time limited exceed
    public static int addDigits(int num){
        if(num<10)return num;
        int sum=0;

        while(true){
            if(num<10)return num;
            while(num>0){
                sum+=num%10;
                num/=10;
            }
            num=sum;
            sum=0;
        }
    }
    //method2
    public static int addDigits1(int num){
        if(num==0)return 0;
        if(num%9==0)return 9;
        else return num%9;
    }
}
