package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/10/19.
 */
public class LC097InterleavingString {
    public static void main(String[] args) {
        String s1="ab";
        String s2="bc";
        String s3="babc";
        System.out.println(isInterleave(s1,s2,s3));
    }
    //DP
    public static boolean isInterleave(String s1,String s2,String s3){
        if(s1.length()+s2.length()!=s3.length())return false;
        int rowNum=s1.length();
        int colNum=s2.length();
        boolean[][] dp=new boolean[rowNum+1][colNum+1];
        dp[0][0]=true;

        for (int row = 1; row <= rowNum; row++) {
            if(s3.charAt(row-1)==s1.charAt(row-1)){
                dp[row][0]|=dp[row-1][0];
            }
        }
        for (int col = 1; col <= colNum; col++) {
            if(s3.charAt(col-1)==s2.charAt(col-1)){
                dp[0][col]|=dp[0][col-1];
            }
        }

        for (int row = 1; row <= rowNum; row++) {
            for (int col = 1; col <= colNum; col++) {
                if(s3.charAt(row+col-1)==s1.charAt(row-1)){
                    dp[row][col]|=dp[row-1][col];
                }
                if(s3.charAt(row+col-1)==s2.charAt(col-1)){
                    dp[row][col]|=dp[row][col-1];
                }

            }
        }
        return dp[rowNum][colNum];
    }
}
