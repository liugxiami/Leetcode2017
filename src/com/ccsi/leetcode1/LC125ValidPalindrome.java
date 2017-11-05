package com.ccsi.leetcode1;

/**
 * Created by gxliu on 2017/11/1.
 */
public class LC125ValidPalindrome {
    public static void main(String[] args) {
        String s="A man, a plan, a canal: Panama";
        //String s="aba    ";
        System.out.println(isPalindrome(s));
    }
    public static boolean isPalindrome(String s){
        if(s==null||s.length()==0)return true;
        int len=s.length();
        int p=0,q=len-1;
        s=s.toLowerCase();
        while(p<q){
            while(p<len&&!Character.isLetterOrDigit(s.charAt(p)))p++;
            while(q>=0&&!Character.isLetterOrDigit(s.charAt(q)))q--;
            if(p>q)return true;
            if(s.charAt(p)==s.charAt(q)){
                p++;
                q--;
            }else return false;
        }
        return true;
    }
}
