package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/7/17.
 */
public class LC006ZigZagConversion {
    public static void main(String[] args) {
        String s="AB";
        System.out.println(convert(s,2));
    }
    public static String convert(String s,int numRows){
        if(s==null||s.length()==0||numRows==0)return null;
        int len=s.length();
        if(numRows==1)return s;

        StringBuilder result=new StringBuilder();
        int size=numRows*2-2;
        for (int row = 0; row < numRows; row++) {
            for (int i = row; i < len; i+=size) {
                result.append(s.charAt(i));

                if(row!=0&&row!=numRows-1){
                    int temp=i+size-2*row;
                    if(temp<len){
                        result.append(s.charAt(temp));
                    }
                }
            }
        }
        return result.toString();
    }
}
