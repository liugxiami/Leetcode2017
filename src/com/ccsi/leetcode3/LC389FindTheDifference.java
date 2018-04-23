package com.ccsi.leetcode3;

/**
 * Created by gxliu on 2018/4/22.
 */
public class LC389FindTheDifference {
    public static void main(String[] args) {
        String s="abcd";
        String t="abcde";
        System.out.println(findTheDifference2(s,t));
    }
    public static char findTheDifference(String s,String t){
        int[] bitMap=new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            bitMap[c-'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            char c=t.charAt(i);
            bitMap[c-'a']--;
            if(bitMap[c-'a']<0)return c;
        }
        return '0';
    }
    public static char findTheDifference1(String s,String t){
        char res=0;
        for (char c:s.toCharArray()) {
            res^=c;
        }
        for(char c:t.toCharArray()){
            res^=c;
        }
        return res;
    }
    //更简洁一些的版本
    public static char findTheDifference2(String s,String t){
        int len=t.length();
        char res=t.charAt(len-1);
        for (int i = 0; i < len - 1; i++) {
            res^=s.charAt(i);
            res^=t.charAt(i);
        }
        return res;
    }
}
