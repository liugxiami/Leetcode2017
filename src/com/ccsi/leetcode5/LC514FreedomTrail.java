package com.ccsi.leetcode5;

import java.util.Arrays;

public class LC514FreedomTrail {
    public static void main(String[] args) {
        String ring="godding";
        String key="gd";
        System.out.println(findRotateStepsDP(ring,key));
    }
    //greedy, but not right solution
    public static int findRotateSteps(String ring,String key){
        int len=ring.length();
        int count=0;
        for (int i = 0; i < key.length(); i++) {
            char curr=key.charAt(i);
            int first=-1;
            int last=-1;
            for (int j = 0; j < len; j++) {
                if(ring.charAt(j)==curr){
                    if(first==-1)first=j;
                    last=j;
                }
            }
            int index=Math.min(first,len-last);
            String left=ring.substring(0,index);
            String right=ring.substring(index);
            count+=Math.min(index,len-index);
            ring=right+left;
            count++;
        }
        return count;
    }
    //DP
    public static int findRotateStepsDP(String ring,String key){
        int cNum=ring.length(); //col
        int rNum=key.length(); //row
        //dp[i][j] is conceptually the minimum steps needed to to complete key[i:],
        //while starting at ring[j]", now I know why we should return dp[0][0] at last..
        //it means the min cost when we have already matched all the characters of key
        //and we start from index = 0 in ring
        int[][] dp=new int[rNum+1][cNum];

        for (int r = rNum-1; r >=0 ; r--) {
            char curr=key.charAt(r);
            for (int c = 0; c < cNum; c++) {
                dp[r][c]=Integer.MAX_VALUE;
                //Try out every type of spin (by 0, 1, 2, 3, and choose the best choice)
                for (int i = 0; i < cNum; i++) {
                    if(ring.charAt(i)==curr){
                        //Using greedy logic that we should just use the min spin
                        int diff=Math.abs(i-c);
                        //Choose the min of moving clockwise or counterclockwise
                        int steps=Math.min(diff,cNum-diff);
                        //dp[k+1][i] = Solve the subproblem from key[k+1: kNum-1] and while our pointer points to i now since
                        //we have rotated the dial there.
                        dp[r][c]=Math.min(dp[r][c],steps+dp[r+1][i]);
                    }
                }
            }
        }
        return dp[0][0]+rNum;//We will press the dial button kNum times in total no matter what.
    }
}
