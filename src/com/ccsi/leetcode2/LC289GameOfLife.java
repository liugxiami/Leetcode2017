package com.ccsi.leetcode2;

/**
 * Created by gxliu on 2018/1/6.
 */
public class LC289GameOfLife {
    public static void main(String[] args) {
        int[][] board={{0,0,0,1},{1,1,1,0},{0,0,0,1},{0,1,0,0}};
        gameOfLife(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void gameOfLife(int[][] board){
        if(board==null||board.length==0||board[0].length==0)return;
        int rowNum=board.length;
        int colNum=board[0].length;

        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                int neighbors=findNeighbor(board,row,col);
                if((board[row][col]&1)==1){
                    if(neighbors==3||neighbors==2)board[row][col]=3;
                }else{
                    if(neighbors==3)board[row][col]=2;
                }
            }
        }

        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                board[row][col]>>=1;
            }
        }
    }
    private static int findNeighbor(int[][] board,int row,int col){
        int count=0;
        for (int i = row-1; i <=row+1 ; i++) {
            for (int j = col-1; j <= col+1; j++) {
                if(i<0||j<0||i>board.length-1||j>board[0].length-1||(i==row&&j==col))continue;
                count+=(board[i][j]&1);
            }
        }

        return count;
    }
}
