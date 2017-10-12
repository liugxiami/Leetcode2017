package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/10/11.
 */
public class LC079WordSearch {
    public static void main(String[] args) {
//        char[][] board={
//                {'A','B','C','E'},
//                {'S','F','C','S'},
//                {'A','D','E','E'}
//        };
        char[][] board={{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        System.out.println(exist(board,"AAB"));
    }
    public static boolean exist(char[][] board,String word){
        if(board==null||word==null||board.length==0||board[0].length==0||word.length()==0)return false;
        int rowNum=board.length;
        int colNum=board[0].length;
        boolean[][] visited=new boolean[rowNum][colNum];
        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                if(DFS(board,row,col,word,0,visited))return true;
            }
        }
        return false;
    }
    private static boolean DFS(char[][] board,int row,int col,String word,int index,boolean[][] visited){
        if(index==word.length())return true;

        if(row<0||row>=board.length||col<0||col>=board[0].length||visited[row][col]||board[row][col]!=word.charAt(index)){
            return false;
        }

        visited[row][col]=true;
        boolean res=DFS(board,row-1,col,word,index+1,visited)||
                DFS(board,row+1,col,word,index+1,visited)||
                DFS(board,row,col-1,word,index+1,visited)||
                DFS(board,row, col+1,word,index+1,visited);
        visited[row][col]=false;

        return res;
    }
}
