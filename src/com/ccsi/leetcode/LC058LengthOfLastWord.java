package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/9/30.
 */
public class LC058LengthOfLastWord {
    public static void main(String[] args) {
        String s="a         ";
        System.out.println(lengthOfLastWord(s));
    }
    public static int lengthOfLastWord(String s){
        if(s==null||s.length()==0)return 0;
        int len=s.length();
        while(len>0&&s.charAt(len-1)==' ')len--;

        int lastLen=0;
        while(len>0&&s.charAt(len-1)!=' '){
            lastLen++;
            len--;
        }

        return lastLen;
    }
}
