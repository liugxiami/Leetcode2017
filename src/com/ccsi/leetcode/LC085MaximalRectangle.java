package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/10/14.
 */
public class LC085MaximalRectangle {
    public static void main(String[] args) {
        char[][] matrix={{'1','0','0','1','0'},
                        {'1','0','1','1','1'},
                        {'1','1','1','1','0'},
                        {'1','0','1','1','1'}};

        System.out.println(maximalRectangle(matrix));
    }

    public static int maximalRectangle(char[][] matrix){
        if(matrix==null||matrix.length==0||matrix[0].length==0)return 0;
        int rowNum=matrix.length;
        int colNum=matrix[0].length;

        int[][] dp=new int[rowNum][colNum];

        for (int i = 0; i < colNum; i++) {
            dp[0][i]=matrix[0][i]-'0';
        }

        for (int row = 1; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                if(matrix[row][col]=='1')dp[row][col]=dp[row-1][col]+1;
                else dp[row][col]=0;
            }
        }

        int max=0;
        for (int i = 0; i < rowNum; i++) {
            max=Math.max(max,maxRec(dp[i]));
        }
        return max;
    }

    private static int maxRec(int[] array){
        if(array==null||array.length==0)return 0;
        int len=array.length;
        int max=0;

        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i <= len; i++) {
            int curr=i==len?0:array[i];
            while(!stack.isEmpty()&&curr<=array[stack.peek()]){
                int currIndex=stack.pop();
                int height=array[currIndex];
                int wide=stack.isEmpty()?i:i-stack.peek()-1;
                max=Math.max(max,height*wide);
            }
            stack.push(i);
        }
        return max;
    }
}
