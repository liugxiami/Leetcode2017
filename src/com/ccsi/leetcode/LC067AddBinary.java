package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/10/4.
 */
public class LC067AddBinary {
    public static void main(String[] args) {
        String a="11110001111";
        String b="11111111111";
        System.out.println(addBinary(a,b));
    }
    public static String addBinary(String a,String b){
        StringBuilder str=new StringBuilder();
        int lenA=a.length();
        int lenB=b.length();
        int len=Math.max(lenA,lenB);
        a=format(a,len);
        b=format(b,len);

        int carries=0;
        for (int i = len-1; i >=0; i--) {
            int temp=a.charAt(i)-'0'+b.charAt(i)-'0'+carries;
            str.append(temp%2);
            carries=temp/2;
        }
        if(carries==1)str.append(1);
        return str.reverse().toString();
    }
    private static String format(String str,int len){
        int delta=len-str.length();
        StringBuilder res=new StringBuilder();
        while(delta-->0)res.append(0);
        res.append(str);
        return res.toString();
    }
}
