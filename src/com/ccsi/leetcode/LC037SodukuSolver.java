package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/9/12.
 */
public class LC037SodukuSolver {
    public static void solveSudoku(char[][] board){
        if(board==null||board.length!=9||board[0].length!=9)return;
        solve(board);
    }

    public static boolean solve(char[][] board){

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char cur=board[row][col];
                if(cur!='.') continue;
                for (char c = '1'; c <= '9'; c++) {
                    if (isValid(board, row, col, c)) {
                        board[row][col] = c;
                        if (solve(board)) return true;
                        board[row][col] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board,int row,int col,char c){
        boolean[] visited=new boolean[10];
        visited[c-'0']=true;
        for (int i = 0; i < 9; i++) {
            if(board[row][i]=='.')continue;
            if(visited[board[row][i]-'0'])return false;
            visited[board[row][i]-'0']=true;
        }

        visited=new boolean[10];
        visited[c-'0']=true;
        for (int i = 0; i < 9; i++) {
            if(board[i][col]=='.')continue;
            if(visited[board[i][col]-'0'])return false;
            visited[board[i][col]-'0']=true;
        }

        visited=new boolean[10];
        visited[c-'0']=true;
        for (int i = 3*(row/3); i < 3*(row/3)+3; i++) {
            for (int j = 3*(col/3); j < 3*(col/3)+3; j++) {
                if(board[i][j]=='.')continue;
                if(visited[board[i][j]-'0'])return false;
                visited[board[i][j]-'0']=true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board={{'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}
