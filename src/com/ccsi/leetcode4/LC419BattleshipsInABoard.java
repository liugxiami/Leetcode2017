package com.ccsi.leetcode4;

import java.util.*;

/**
 * Created by gxliu on 2018/6/1.
 */
public class LC419BattleshipsInABoard {
    public static void main(String[] args) {
        char[][] board={{'x','.','.','x'},{'.','.','.','x'},{'x','.','.','x'}};
        System.out.println(countBattleshipsDFS(board));
    }
    //method1,比后面的DFS,BFS好些，也可以用UF来做。
    public static int countBattleships(char[][] board){
        if(board==null||board.length==0||board[0].length==0)return 0;
        int rowNum=board.length;
        int colNum=board[0].length;
        int result=0;
        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                if(board[row][col]=='.')continue;
                if(row>0&&board[row-1][col]=='x')continue;
                if(col>0&&board[row][col-1]=='x')continue;
                result++;
            }
        }
        return result;
    }
    //method2 DFS
    public static int countBattleshipsDFS(char[][] board){
        if(board==null||board.length==0||board[0].length==0)return 0;
        int rowNum=board.length;
        int colNum=board[0].length;
        int result=0;

        boolean[][] visited=new boolean[rowNum][colNum];
        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                if(!visited[row][col]&&board[row][col]=='x'){
                    //DFS(board,visited,row,col);
                    BFS(board,visited,row,col);
                    result++;
                }
            }
        }
        return result;
    }
    private static void DFS(char[][] board,boolean[][] visited,int row,int col){
        visited[row][col]=true;
        int[] x={0,0,-1,1};
        int[] y={-1,1,0,0};
        for (int i = 0; i < 4; i++) {
            int r=row+x[i];
            int c=col+y[i];
            if(r>=0&&r<board.length&&c>=0&&c<board[0].length&&board[r][c]=='x'&&!visited[r][c])
                DFS(board,visited,r,c);
        }
    }
    private static void BFS(char[][] board,boolean[][] visited,int row,int col){
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{row,col});
        visited[row][col]=true;
        int[] x={0,0,-1,1};
        int[] y={-1,1,0,0};

        while(!queue.isEmpty()){
            int[] curr=queue.poll();
            for(int i=0;i<4;i++){
                int r=curr[0]+x[i];
                int c=curr[1]+y[i];
                if(r>=0&&r<board.length&&c>=0&&c<board[0].length&&board[r][c]=='x'&&!visited[r][c]){
                    queue.offer(new int[]{r,c});
                    visited[r][c]=true;
                }
            }
        }
    }
}
