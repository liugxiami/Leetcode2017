package com.ccsi.leetcode3;

/**
 * Created by gxliu on 2018/4/24.
 */
public class LC392IsSubsequence {
    public static void main(String[] args) {
        String s="abc";
        String t="ahbgdc";
        System.out.println(isSubsequence1(s,t));
    }
    //双指针
    public static boolean isSubsequence(String s,String t){
        if(s==null||s.length()==0)return true;
        if(t==null||t.length()==0||s.length()>t.length())return false;
        int sIndex=0;
        int tIndex=0;

        while(tIndex<t.length()){
            if(s.charAt(sIndex)==t.charAt(tIndex)){
                sIndex++;
                if(sIndex==s.length())return true;
            }
            tIndex++;
        }
        return false;
    }
    public static boolean isSubsequence1(String s,String t){
        if(s==null||s.length()==0)return true;
        if(t==null||t.length()==0||s.length()>t.length())return false;

        char[] sChars=s.toCharArray();
        char[] tChars=t.toCharArray();

        int sIndex=0;
        int tIndex=0;
        while(sIndex<s.length()&&tIndex<t.length()){
            if(sChars[sIndex]==tChars[tIndex])sIndex++;
            tIndex++;
        }

        return sIndex==s.length();
    }
}
