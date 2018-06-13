package com.ccsi.leetcode4;

/**
 * Created by gxliu on 2018/6/3.
 */
public class LC420StrongPasswordChecker {
    public static int strongPasswordChecker(String s){
        int res=0,a=1,A=1,d=1;
        char[] chars=s.toCharArray();
        int[] repeats=new int[chars.length];//用来保存repeats

        for (int i = 0; i < chars.length; ) {
            if(Character.isLowerCase(chars[i]))a=0;
            if(Character.isUpperCase(chars[i]))A=0;
            if(Character.isDigit(chars[i]))d=0;

            int j=i;
            while(i<chars.length&&chars[i]==chars[j])i++;
            repeats[j]=i-j;
        }

        int total_missing=a+A+d;
        //先处理长度小于6的情况
        if(chars.length<6){
            res+=total_missing+Math.max(0,6-(chars.length+total_missing));
        }else{
            int over_len=Math.max(0,chars.length-20),left_over=0;
            res+=over_len;

            //将repeats处理成3m+2的形式
            for (int k = 1; k < 3; k++) {
                for (int i = 0; i < chars.length&&over_len>0; i++) {
                    if(repeats[i]<3||repeats[i]%3!=(k-1))continue;
                    repeats[i]-=Math.min(over_len,k);
                    over_len-=k;
                }
            }
            //??
            for (int i = 0; i < chars.length; i++) {
                if(repeats[i]>=3&&over_len>0){
                    int need=repeats[i]-2;
                    repeats[i]-=over_len;
                    over_len-=need;
                }

                if(repeats[i]>=3)left_over+=repeats[i]/3;
            }
            res+=Math.max(total_missing,left_over);
        }
        return res;
    }
}
