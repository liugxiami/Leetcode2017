package com.ccsi.leetcode5;

public class LC504Base7 {
    public static void main(String[] args) {
        int num=101;
        System.out.println(convertToBase7(num));
    }
    public static String convertToBase7(int num){
        int sign=1;
        if(num<0){
            num=-num;
            sign=-1;
        }
        if(num<7)return String.valueOf(num*sign);
        StringBuilder sb=new StringBuilder();
        while(num>0){
            sb.append(num%7);
            num/=7;
        }
        if (sign==-1)sb.append('-');
        return sb.reverse().toString();
    }
}
