package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/7/18.
 */
public class LC008StringToInteger {
    public static void main(String[] args) {
        String str="976538755555555556512345";
        System.out.println(myAtoi(str));
    }
    public static int myAtoi(String str){
        if(str==null) return 0;
        //首先要去掉前后的空格。
        str=str.trim();
        if(str.length()==0)return 0;

        int start=0,end=str.length()-1;
        int flag=1; //保存正负号用。

        if(str.charAt(0)=='-'){
            flag=-1;
            start++;
        }

        if(str.charAt(0)=='+'){
            start++;
        }

        //用一个long类型的变量来暂存中间数。
        long result=0;
        for (int i = start; i <= end; i++) {
            //需要判断字符是否是数字，不是的话就直接断掉，是的话就继续计算。
            if(str.charAt(i)<'0'||str.charAt(i)>'9'){
                break;
            }

            result=result*10+(str.charAt(i)-'0');
            if(result>Integer.MAX_VALUE)break;
        }

        //判断这个是是最大数还是最小数，注意最大数和最小数在绝对值上并不是相等的，所以需要分别判断。
        if(result*flag>=Integer.MAX_VALUE)return Integer.MAX_VALUE;
        if(result*flag<=Integer.MIN_VALUE)return Integer.MIN_VALUE;

        return (int)result*flag;

    }
}
