package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/10/4.
 */
public class LC066PlusOne {
    public static void main(String[] args) {
        int[] digits={9,9,9,9,9};
        int[] res=plusOne1(digits);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
    //method1:常规思路，就是从后往前迭代，需要一个进位局部参数。循环结束之后判断进位是否为1，是就要重新声明一个
    //len+1的数组。
    public static int[] plusOne(int[] digits){
        int len=digits.length;
        int flag=1;
        for (int i = len-1; i >=0&&flag==1; i--) {
            int temp=digits[i]+flag;
            flag=temp/10;
            digits[i]=temp%10;
        }

        if(flag==1){
            int[] result=new int[len+1];
            result[0]=flag;
            for (int i = 0; i < len; i++) {
                result[i+1]=digits[i];
            }
            return result;
        }else return digits;
    }
    //method2
    public static int[] plusOne1(int[] digits){
        int len=digits.length;
        boolean hasCarry=false;
        for (int i = len-1; i >=0 ; i--) {
            if(digits[i]==9){
                digits[i]=0;
                hasCarry=true;
            }
            else {
                digits[i]++;
                hasCarry=false;
                break;
            }
        }

        if(hasCarry){
            int[] result=new int[len+1];
            result[0]=1;
            return result;
        }else return digits;
    }
}
