package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/7/20.
 */
public class LC012IntegerToRoman {
    public static void main(String[] args) {
        int num=3978;
        System.out.println(intToRoman(num));
    }
    public static String intToRoman(int num){
        int[] digits={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romans={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder result=new StringBuilder();
        int index=0;
        while(num>0&&index<13){
            int counts=num/digits[index];
            num%=digits[index];
            while(counts-->0){
                result.append(romans[index]);
            }

            index++;
        }

        return result.toString();
    }
}
