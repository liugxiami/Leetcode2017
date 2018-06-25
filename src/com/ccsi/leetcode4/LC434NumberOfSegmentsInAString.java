package com.ccsi.leetcode4;

/**
 * Created by gxliu on 2018/6/24.
 */
public class LC434NumberOfSegmentsInAString {
    public static void main(String[] args) {
        String s="   hello, my name is    John   ";
        System.out.println(countSegments(s));
    }
    public static int countSegments(String s){
        if(s==null||s.length()==0)return 0;
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            //碰到不是空格并且前一个是空格，或者这当前就是第一个字符。
            if(s.charAt(i)!=' '&&(i==0||s.charAt(i-1)==' '))count++;
        }
        return count;
    }
}
