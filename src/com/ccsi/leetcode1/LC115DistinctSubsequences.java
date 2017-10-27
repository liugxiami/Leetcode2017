package com.ccsi.leetcode1;

/**
 * Created by gxliu on 2017/10/26.
 */
public class LC115DistinctSubsequences {
    public static void main(String[] args) {
        String s="rabbbit";
        String t="rabbit";
        System.out.println(numDistict(s,t));
    }
    //DP
    public static int numDistict(String s,String t){
        if(s==null||t==null)return 0;
        int sLen=s.length();
        int tLen=t.length();
        int[][] cache=new int[tLen+1][sLen+1];
        for (int col = 0; col <= sLen; col++) {
            cache[0][col]=1;
        }

        for (int row = 1; row <= tLen; row++) {
            for (int col = 1; col <= sLen; col++) {
                cache[row][col]+=cache[row][col-1];
                if(s.charAt(col-1)==t.charAt(row-1))cache[row][col]+=cache[row-1][col-1];
            }
        }

        return cache[tLen][sLen];
    }
}
