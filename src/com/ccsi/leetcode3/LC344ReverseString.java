package com.ccsi.leetcode3;

/**
 * Created by gxliu on 2018/3/15.
 */
public class LC344ReverseString {
    public static void main(String[] args) {
        String s="hello";
        System.out.println(reverseString2(s));
    }
    public static String reverseString(String s){
        if(s==null||s.length()<=1)return s;
        int len=s.length();
        char[] array=s.toCharArray();

        int p=0;
        int q=len-1;
        while(p<q){
           char c=array[p];
           array[p]=array[q];
           array[q]=c;
           p++;
           q--;
        }

        return new String(array);
    }
    public static String reverseString1(String s){
        if(s==null||s.length()<2)return s;
        return new StringBuffer(s).reverse().toString();
    }

    public static String reverseString2(String s){
        if(s==null||s.length()<2)return s;
        return helper(s);
    }
    private static String helper(String s){
        if(s.length()<2)return s;
        int mi=s.length()/2;
        String left=helper(s.substring(0,mi));
        String right=helper(s.substring(mi));
        return right+left;
    }
}
