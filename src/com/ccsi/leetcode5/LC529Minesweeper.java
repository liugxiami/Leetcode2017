package com.ccsi.leetcode5;

import java.util.LinkedList;
import java.util.Queue;

public class LC529Minesweeper {
    public static void main(String[] args) {
        char[][] board={{'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};
        int[] click=new int[]{3,0};
        char[][] result=updateBoardDFS(board,click);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }
    private static int rowNum;
    private static int colNum;
    //method1 BFS
    public static char[][] updateBoard(char[][] board,int[] click){
        rowNum=board.length;
        colNum=board[0].length;
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(click);
        while(!queue.isEmpty()){
            int[] temp=queue.poll();
            int row=temp[0],col=temp[1];
            if(board[row][col]=='M'||board[row][col]=='X'){
                board[row][col]='X';
                return board;
            }

            int count=0;
            count=aroundMindNum(board,new int[]{row,col});
            if(count>0){
                board[row][col]=(char)('0'+count);
            }else{
                board[row][col]='B';
                for(int i=-1;i<=1;i++){
                    for (int j = -1; j <=1 ; j++) {
                        if(i==0&&j==0)continue;
                        if(row+i<0||row+i>=rowNum||col+j<0||col+j>=colNum)continue;
                        if(board[row+i][col+j]=='E'){
                            queue.offer(new int[]{row+i,col+j});
                        }
                    }
                }
            }
        }
        return board;
    }
    //method2 DFS
    public static char[][] updateBoardDFS(char[][] board,int[] click){
        rowNum=board.length;
        colNum=board[0].length;
        int row=click[0],col=click[1];
        if(board[row][col]=='M'||board[row][col]=='X'){ //碰到地雷直接爆炸，return
            board[row][col]='X';
            return board;
        }
        //计算当前这个四周有无雷
        int count=0;
        count=aroundMindNum(board,click);
        if(count>0){ //如果有雷的话，停止搜索
            board[row][col]=(char)('0'+count);
        }else{ //剩下的就是这是个空白的E,继续搜索。
            board[row][col]='B';
            for (int i = -1; i <=1; i++) {
                for (int j = -1; j <=1 ; j++) {
                    if(i==0&&j==0)continue; //自己，跳过
                    int r=row+i;
                    int c=col+j;
                    if(r<0||r>=rowNum||c<0||c>=colNum)continue; //出边界了，跳过
                    if(board[r][c]=='E') updateBoardDFS(board,new int[]{r,c});
                }
            }
        }
        return board;
    }
    private static int aroundMindNum(char[][] board,int[] pos){
        int mineNum=0;
        for(int i=pos[0]-1;i<=pos[0]+1;i++){
            if(i<0||i>=rowNum)continue;
            for (int j = pos[1]-1; j <=pos[1]+1 ; j++) {
                if(j<0||j>=colNum||(i==pos[0]&&j==pos[1]))continue;
                if(board[i][j]=='M')mineNum++;
            }
        }
        return mineNum;
    }
}
