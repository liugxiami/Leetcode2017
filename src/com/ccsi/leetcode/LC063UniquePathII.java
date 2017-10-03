package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/10/2.
 */
public class LC063UniquePathII {
    public static void main(String[] args) {
        int[][] obstacleGrid={{0,0,1,0},{0,1,0,0},{0,0,0,0}};
        System.out.println(uniquePathsWithObstacles1(obstacleGrid));
    }
    //O(m*n)
    public static int uniquePathsWithObstacles(int[][] obstacleGrid){
        if(obstacleGrid==null||obstacleGrid.length==0||obstacleGrid[0].length==0)return 1;
        int row=obstacleGrid.length;
        int col=obstacleGrid[0].length;
        int[][] cache=new int[row][col];

        for (int i = 0; i < col; i++) {
            if(obstacleGrid[0][i]==1)break;
            cache[0][i]=1;
        }

        for (int i = 0; i < row; i++) {
            if(obstacleGrid[i][0]==1)break;
            cache[i][0]=1;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if(obstacleGrid[i][j]==1){
                    cache[i][j]=0;
                    continue;
                }
                if(cache[i][j-1]==0)cache[i][j]=cache[i-1][j];
                else cache[i][j]=cache[i-1][j]+cache[i][j-1];
            }
        }
        return cache[row-1][col-1];
    }
    //优化
    public static int uniquePathsWithObstacles1(int[][] obstaclesGrid){
        if(obstaclesGrid==null||obstaclesGrid.length==0||obstaclesGrid[0].length==0)return 1;
        int row=obstaclesGrid.length;
        int col=obstaclesGrid[0].length;

        int[] cache=new int[col];
        for (int i = 0; i < col; i++) {
            if(obstaclesGrid[0][i]==1)break;
            cache[i]=1;
        }

        for (int i = 1; i < row; i++) {
            if(obstaclesGrid[i][0]==1)cache[0]=0;
            for (int j = 1; j < col; j++) {
                if(obstaclesGrid[i][j]==1){
                    cache[j]=0;
                    continue;
                }
                cache[j]+=cache[j-1];
            }
        }
        return cache[col-1];
    }
}
