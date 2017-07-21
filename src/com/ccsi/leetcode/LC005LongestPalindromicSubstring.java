package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/7/13.
 */
public class LC005LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s="ccc";
        System.out.println(longestPalindrome1(s));
    }
    //O(N^2)
    public static String longestPalindrome(String s){
        if(s==null||s.length()==0)return null;
        int len=s.length();
        int max=0;
        String result=null;
        for (int start = 0; start <=len-1 ; start++) {
            for (int end = start+1; end <= len; end++) {
                String curr=s.substring(start,end);
                if(isPalindrome(curr)){
                    if(max<curr.length()){
                        max=curr.length();
                        result=curr;
                    }
                }
            }
        }
        return result;
    }
    private static boolean isPalindrome(String str){
        if(str.length()<=1)return true;
        int start=0;
        int end=str.length()-1;
        while(start<end){
            if(str.charAt(start)!=str.charAt(end))return false;
            start++;
            end--;
        }
        return true;
    }

    public static String longestPalindrome1(String s){
        if(s==null||s.length()==0)return null;
        int len=s.length();
        if(len==1)return s;

        int max=0;
        String result=null;
        for (int i = 0; i < len-1; i++) {
            if(s.charAt(i)==s.charAt(i+1)){
                int step=searchPalidrome(s,i,i+1);
                int currLen=step*2+2;
                if(max<currLen){
                    max=currLen;
                    result=s.substring(i-step,i+2+step);
                }
            }
            //此处不能用else，否则，比如“ccc”就会出错，返回cc，而不是ccc。
            int step=searchPalidrome(s,i,i);
            int currLen=step*2+1;
            if(max<currLen){
                max=currLen;
                result=s.substring(i-step,i+1+step);
            }
        }
        return result;
    }
    private static int searchPalidrome(String s,int left,int right){
        int step=0;
        while(s.charAt(left-step)==s.charAt(right+step)){
            step++;
            if(left-step<0||right+step>=s.length())break;
        }
        return step-1;
    }
}
