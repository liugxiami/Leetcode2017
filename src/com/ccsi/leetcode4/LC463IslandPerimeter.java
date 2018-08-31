package com.ccsi.leetcode4;

public class LC463IslandPerimeter {
    public static void main(String[] args) {
        int[][] grid={{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(islandPerimeter(grid));
    }
    public static int islandPerimeter(int[][] grid){
        if(grid==null||grid.length==0||grid[0].length==0)return 0;
        int rowNum=grid.length;
        int colNum=grid[0].length;

        int squares=0;
        int cross=0;
        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                if(grid[row][col]==1){
                    squares++;
                    if(row>0&&grid[row-1][col]==1)cross++;
                    if(col>0&&grid[row][col-1]==1)cross++;
                }
            }
        }
        return squares*4-cross*2;
    }
}
