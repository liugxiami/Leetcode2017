package com.ccsi.leetcode5;

public class LC583DeleteOperationForTwoStrings {
    public static void main(String[] args) {
        String word1="eat";
        String word2="sea";
        System.out.println(minDistance(word1,word2));
    }
    //DP dp[i][j] longest common subsequence, i---word1 index,j---word2 index, means
    //until word1 from 0 to i and word2 from 0 to j, current longest common subsequence.
    public static int minDistance(String word1,String word2){
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i <= word1.length(); i++) { //注意，是<=
            for (int j = 0; j <= word2.length(); j++) {
                if(i==0||j==0)dp[i][j]=0; //i==0,表示word1是空的，而非第一个字符（index为0）
                else dp[i][j]=(word1.charAt(i-1)==word2.charAt(j-1))?dp[i-1][j-1]+1:Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        int longest=dp[word1.length()][word2.length()]; //最长的相同子序列。
        return word1.length()-longest+word2.length()-longest;
    }
}
