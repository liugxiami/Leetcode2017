package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/11/27.
 */
public class LC166FractionToRecurringDecimal {
    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1,-2147483648));
    }
    public static String fractionToDecimal(int numerator,int denominator){
        if(numerator==0)return "0"; //分子为0，则结果为0
        if(denominator==0)return ""; //分母为0，则没法除，结果就是空的

        StringBuilder result=new StringBuilder();  //用一个sb来保存结果
        if(numerator<0&&denominator<0)result.append("");
        else if(numerator<0||denominator<0)result.append('-'); //先检查正负数

        long num=Math.abs((long)numerator);  //将分子分母变成正数再计算，但要注意Integer.MIN_VALUE的绝对值用int存储不下
        long den=Math.abs((long)denominator); //暂时换成long型来做。

        result.append(num/den);  //整数部分。
        long rem=num%den;
        if(rem==0)return result.toString(); //如果余数部分是0，就可以直接返回了。
        //否则就用进行除法计算，用余数*10再对分母进行整除，这时用一个map来存储整除的情况，其中
        Map<Long,Integer> map=new HashMap<>();//key->remains,value->index（这是为了提取重复的小数位）
        StringBuilder dec=new StringBuilder(); //其实这个可以省，直接用result就好了
        while(rem!=0){
            if(map.containsKey(rem)){//如果有重复的小数出现
                int start=map.get(rem);
                String left=dec.substring(0,start);
                String right=dec.substring(start);
                result.append('.').append(left).append('(').append(right).append(')');
                return result.toString();
            }

            map.put(rem,dec.length());
            rem*=10;
            dec.append(rem/den);
            rem%=den;
        }
        return result.append('.').append(dec).toString(); //如果没有出现无限重复的情况。
    }
}
