package com.ccsi.leetcode5;

public class LC516LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s="abccba";
        System.out.println(longestPalindromeSubseq1(s));
    }
    //method 1 DP
    //DP[i][j]----longest Palindrome subseq between i to j
    public static int longestPalindromeSubseq(String s){
        if(s==null||s.length()==0)return 0;
        int len=s.length();
        int[][] dp=new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i]=1;
        }

        for (int i = len-1; i >=0 ; i--) {
            for (int j = i+1; j <len ; j++) {
                if(s.charAt(i)==s.charAt(j))dp[i][j]=dp[i+1][j-1]+2;
                else dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }
        return dp[0][len-1];
    }
    //recursion DP
    public static int longestPalindromeSubseq1(String s){
        int len=s.length();
        return helper(s,0,len-1,new int[len][len]);
    }
    private static int helper(String s,int left,int right,int[][] dp){
        if(left>right)return 0;
        if(left==right) return 1;
        if(dp[left][right]!=0)return dp[left][right];

        if(s.charAt(left)==s.charAt(right))dp[left][right]=helper(s,left+1,right-1,dp)+2;
        else dp[left][right]=Math.max(helper(s,left+1,right,dp),helper(s,left,right-1,dp));
        return dp[left][right];
    }
}
