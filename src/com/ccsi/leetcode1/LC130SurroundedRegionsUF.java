package com.ccsi.leetcode1;

/**
 * Created by gxliu on 2017/11/8.
 * leetcode 200
 */
public class LC130SurroundedRegionsUF {
    public class Position{
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public class UFElement{
        Position key;
        Position parent;
        int rank;
        boolean canFlip;

        public UFElement(Position key, Position parent) {
            this.key = key;
            this.parent = parent;
            this.rank = 1;
            this.canFlip = true;
        }
    }

    private UFElement[][] core;

    private void makeSet(char[][] board,int rowNum,int colNum){
        core=new UFElement[rowNum][colNum];
        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                if(board[row][col]=='o'){
                    Position curr=new Position(row,col);
                    core[row][col]=new UFElement(curr,curr);
                    if(row==0||col==0||row==rowNum-1||col==colNum-1){
                        core[row][col].canFlip=false;
                    }
                }
            }
        }
    }
    private void union(Position p1,Position p2){
        Position parent1=find(p1);
        Position parent2=find(p2);
        if(parent1.row==parent2.row&&parent1.col==parent2.col)return;
        UFElement UFparent1=core[parent1.row][parent1.col];
        UFElement UFparent2=core[parent2.row][parent2.col];
        if(UFparent1.rank<UFparent2.rank){
            UFparent1.parent=parent2;
        }else if(UFparent1.rank>UFparent2.rank){
            UFparent2.parent=parent1;
        }else{
            UFparent1.parent=parent2;
            UFparent2.rank++;
        }

        UFparent1.canFlip&=UFparent1.canFlip;
        UFparent2.canFlip&=UFparent2.canFlip;
    }
    private Position find(Position p){
        UFElement curr=core[p.row][p.col];
        UFElement ele=curr;
        while (true){
            Position parent=curr.parent;
            if(parent.row==curr.key.row&&parent.col==curr.key.col){
                ele.parent=parent;//路径压缩。
                return parent;
            }
            curr=core[parent.row][parent.col];
        }
    }
    public void solve(char[][] board){
        if(board==null||board.length==0||board[0].length==0)return;
        int rowNum=board.length;
        int colNum=board[0].length;
        if(rowNum<3||colNum<3)return;

        makeSet(board,rowNum,colNum);
        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                if(board[row][col]=='o'){
                    Position curr=new Position(row,col);
                    if(row+1<rowNum&&board[row+1][col]=='o')union(curr,new Position(row+1,col));
                    //if(row-1>=0&&board[row-1][col]=='o')union(curr,new Position(row-1,col));
                    if(col+1<colNum&&board[row][col+1]=='o')union(curr,new Position(row,col+1));
                    //if(col-1>=0&&board[row][col-1]=='o')union(curr,new Position(row+1,col-1));
                }
            }
        }

        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                if(board[row][col]=='o'){
                    Position parent=find(new Position(row,col));
                    if(core[parent.row][parent.col].canFlip){
                        board[row][col]='x';
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        LC130SurroundedRegionsUF uf=new LC130SurroundedRegionsUF();
        char[][] board={
                {'x','x','x','x'},
                {'x','o','o','x'},
                {'x','x','o','x'},
                {'x','o','x','x'}
        };
        uf.solve(board);
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                System.out.print(board[row][col]+" ");
            }
            System.out.println();
        }
    }
}
