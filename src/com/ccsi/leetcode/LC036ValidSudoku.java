package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/9/11.
 */
public class LC036ValidSudoku {
    public static boolean isValidSudoku(char[][] board){
        if(board==null||board.length!=9||board[0].length!=9)return false;

        for (int row = 0; row < 9; row++) {
            int[] map=new int[10];
            for (int col = 0; col < 9; col++) {
                int num=board[row][col]-'0';
                if(board[row][col]=='.')continue;
                if(num<0||num>9)return false;
                if(map[num]==1)return false; //visited;
                map[num]=1;
            }
        }

        for (int col = 0; col < 9; col++) {
            int[] map=new int[10];
            for (int row = 0; row < 9; row++) {
                int num=board[row][col]-'0';
                if(board[row][col]=='.')continue;
                if(num<0||num>9)return false;
                if(map[num]==1)return false;
                map[num]=1;
            }
        }

        for (int row = 0; row < 9; row+=3) {
            for (int col = 0; col < 9; col+=3) {
                int[] map=new int[10];
                for (int i = row; i < row+3; i++) {
                    for (int j = col; j < col+3; j++) {
                        int num=board[i][j]-'0';
                        if(board[i][j]=='.')continue;
                        if(num<0||num>9)return false;
                        if(map[num]==1)return false;
                        map[num]=1;
                    }
                }
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
                        {'7','.','.','.','4','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(board));
    }
}
