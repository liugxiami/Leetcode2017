package com.ccsi.leetcode1;

/**
 * Created by gxliu on 2017/11/29.
 */
public class LC171ExcelSheetColumnNumber {
    public static void main(String[] args) {
        System.out.println(titleToNumber("BA"));
    }
    //本质是26进制转换10进制
    public static int titleToNumber(String s){
        int result=0;
        for (int i = 0; i < s.length(); i++) {
            char curr=s.charAt(i);
            result=result*26+curr-'A'+1;
        }
        return result;
    }
}
