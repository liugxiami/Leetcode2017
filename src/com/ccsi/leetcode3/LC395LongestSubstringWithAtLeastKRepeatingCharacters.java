package com.ccsi.leetcode3;

/**
 * Created by gxliu on 2018/5/2.
 */
public class LC395LongestSubstringWithAtLeastKRepeatingCharacters {
    public static void main(String[] args) {
        String s="ababbc";
        System.out.println(longestSubstring(s,2));
    }
    //divide-conquer
    /*要找s[i,j]的最大子串，先统计频数，然后遍历一遍频数，找出第一个频数小于k且大于0的字符，然后找出这个字
    * 符的位置，接下来的分析很重要，这个字符一定不能出现在任何的子串中，因为i,j是整个的子串，在ij里面频数
    * 都没有达到k，那么在ij的任何子串中，这个字符也不可能达到频数k。所以不能有这个字符，那么就在这个位置做
    * 一个分治，返回前半部分和后半部分的最大值。
    */
    public static int longestSubstring(String s,int k){
        if(s==null||s.length()<k)return 0;
        return helper1(s,k,0,s.length()-1);
    }
    //method1
    private static int helper(String s,int k,int start,int end){
        if(start>end)return 0;

        int[] count=new int[26];
        for (int i = start; i <= end; i++) {
            count[s.charAt(i)-'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if(count[i]>0&&count[i]<k){
                int position=s.indexOf((char)(i+'a'),start);
                return Math.max(helper(s,k,start,position-1),helper(s,k,position+1,end));
            }
        }

        return end-start+1;
    }
    //method2
    private static int helper1(String s,int k,int start,int end){
        if(start>end) return 0;
        int[] count=new int[26];
        for (int i = start; i <= end; i++) {
            count[s.charAt(i)-'a']++;
        }

        for (int i = start; i <= end; i++) {
            int curr=s.charAt(i)-'a';
            if(count[curr]>0&&count[curr]<k){
                return Math.max(helper1(s,k,start,i-1),helper1(s,k,i+1,end));
            }
        }
        return end-start+1;
    }
}
