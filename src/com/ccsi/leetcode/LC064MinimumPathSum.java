package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/10/3.
 */
public class LC064MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid={{1,3,2,4,5},{3,2,4,8,14},{4,3,7,9,10}};
        System.out.println(minPathSum1(grid));
    }
    //method1 DP O(m*n)
    public static int minPathSum(int[][] grid){
        if(grid==null||grid.length==0||grid[0].length==0)return 0;
        int row=grid.length;
        int col=grid[0].length;

        int[][] cache=new int[row][col];
        cache[0][0]=grid[0][0];

        for (int i = 1; i < row; i++) {
            cache[i][0]=cache[i-1][0]+grid[i][0];
        }

        for (int i = 1; i < col; i++) {
            cache[0][i]=cache[0][i-1]+grid[0][i];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                cache[i][j]=Math.min(cache[i-1][j],cache[i][j-1])+grid[i][j];
            }
        }

        return cache[row-1][col-1];
    }
    //method2 DP O(n)
    public static int minPathSum1(int[][] grid){
        if(grid==null||grid.length==0||grid[0].length==0)return 0;
        int row=grid.length;
        int col=grid[0].length;

        int[] cache=new int[col];

        cache[0]=grid[0][0];
        for (int i = 1; i < col; i++) {
            cache[i]=cache[i-1]+grid[0][i];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(j==0)cache[j]+=grid[i][0];
                else cache[j]=Math.min(cache[j],cache[j-1])+grid[i][j];
            }
        }

        return cache[col-1];
    }
}
