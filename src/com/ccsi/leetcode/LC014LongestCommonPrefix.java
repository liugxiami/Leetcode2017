package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/7/21.
 */
public class LC014LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs={"abc","abcd","abcde","abce"};
        System.out.println(longestCommonPrefix1(strs));
    }
    //method1
    public static String longestCommonPrefix(String[] strs){
        if(strs==null||strs.length==0)return "";
        String prefix=strs[0];
        for (int i = 1; i < strs.length; i++) {
            int index=0;
            int len=Math.min(prefix.length(),strs[i].length());
            while(index<len&&prefix.charAt(index)==strs[i].charAt(index))index++;
            if(index==0)return "";

            prefix=prefix.substring(0,index);
        }
        return prefix;
    }
    //method2
    public static String longestCommonPrefix1(String[] strs){
        if(strs==null||strs.length==0)return "";
        StringBuilder prefix=new StringBuilder();
        int index=0;
        while(true){
            if(index>=strs[0].length())break;
            char c=strs[0].charAt(index);
            int i=1;
            for (; i < strs.length; i++) {
                if(index>=strs[i].length())break;
                if(strs[i].charAt(index)!=c)break;
            }
            if(i!=strs.length)break;
            prefix.append(c);
            index++;
        }
        return prefix.toString();
    }
}
