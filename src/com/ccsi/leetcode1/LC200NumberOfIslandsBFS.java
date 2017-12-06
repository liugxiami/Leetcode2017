package com.ccsi.leetcode1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gxliu on 2017/12/4.
 */
public class LC200NumberOfIslandsBFS {
    public static void main(String[] args) {
        LC200NumberOfIslandsBFS find=new LC200NumberOfIslandsBFS();
        char[][] grid={{'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};
//        char[][] grid={{'1','1','0','0','0'},
//                {'1','1','0','0','0'},
//                {'0','0','1','0','0'},
//                {'0','0','0','1','1'}};
        System.out.println(find.numIslands(grid));
    }
    private class Position{
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int count=0;
    public int numIslands(char[][] grid){
        if(grid==null||grid.length==0||grid[0].length==0)return 0;
        int rowNum=grid.length;
        int colNum=grid[0].length;
        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                if(grid[row][col]=='1'){
                    count++;
                    BFS(grid,row,col,rowNum,colNum);
                }
            }
        }
        return count;
    }
    private void BFS(char[][] grid,int row,int col,int rowNum,int colNum){
        Queue<Position> queue=new LinkedList<>();
        queue.offer(new Position(row,col));
        while(!queue.isEmpty()){
            Position curr=queue.poll();
            int i=curr.row;
            int j=curr.col;

            grid[i][j]='2';

            if(i+1<rowNum&&grid[i+1][j]=='1')queue.offer(new Position(i+1,j));
            if(i-1>=0&&grid[i-1][j]=='1')queue.offer(new Position(i-1,j));
            if(j+1<colNum&&grid[i][j+1]=='1')queue.offer(new Position(i,j+1));
            if(j-1>=0&&grid[i][j-1]=='1')queue.offer(new Position(i,j-1));
        }
    }
}
