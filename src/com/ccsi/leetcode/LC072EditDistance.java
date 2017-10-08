package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/10/8.
 * 典型的dp题。
 */

public class LC072EditDistance {
    public static void main(String[] args) {
        String word1="hello";
        String word2="world";
        System.out.println(minDistance(word1,word2));
    }
    public static int minDistance(String word1,String word2){
        if(word1==null&&word2==null)return 0;
        if(word1==null||word2==null)return word1==null?word2.length():word1.length();

        int len1=word1.length();
        int len2=word2.length();
        int cost;

        int[][] dp=new int[len1+1][len2+1];

        //initialize 因为全部都需要插入
        for (int i = 0; i <= len1; i++) {
            dp[i][0]=i;
        }

        for (int i = 0; i <= len2; i++) {
            dp[0][i]=i;
        }

        for (int row = 1; row <= len1; row++) {
            for (int col = 1; col <= len2; col++) {
                dp[row][col]=Math.min(dp[row-1][col],dp[row][col-1])+1; //编辑距离+1
                cost=word1.charAt(row-1)==word2.charAt(col-1)?0:1; //如果从i-1，j-1位置变换过来，是一样的话不变，否则+1
                dp[row][col]=Math.min(dp[row][col],dp[row-1][col-1]+cost);
            }
        }
        return dp[len1][len2];
    }
}
