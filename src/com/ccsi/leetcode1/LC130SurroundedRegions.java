package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/11/7.
 */
public class LC130SurroundedRegions {

    public static void main(String[] args) {
        char[][] board={
                {'x','x','x','x'},
                {'x','o','o','x'},
                {'x','x','o','x'},
                {'x','o','x','x'}
        };
//        char[][] board={
//                {'o','o','o'},
//                {'o','o','o'},
//                {'o','o','o'},
//        };
        solve(board);
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                System.out.print(board[row][col]+" ");
            }
            System.out.println();
        }
    }
    //method1 union-find
    private static class Element{
        int value;
        int parent;
        int rank;
        boolean canFlip;

        public Element(int value, int parent) {
            this.value = value;
            this.parent = parent;
            this.rank=1;
            this.canFlip = true;
        }
    }
    private static Map<Integer,Element> elements=new HashMap<>();

    public static void solve(char[][] board){
        if(board==null||board.length==0||board[0].length==0)return;
        makeSet(board);
        int rowNum=board.length;
        int colNum=board[0].length;

        if(rowNum<3||colNum<3)return;

        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                if(row+1<rowNum&&board[row][col]=='o'&&board[row+1][col]=='o'){
                    union(row*colNum+col,(row+1)*colNum+col);
                }
                if(col+1<colNum&&board[row][col]=='o'&&board[row][col+1]=='o'){
                    union(row*colNum+col,row*colNum+col+1);
                }
            }
        }

        for(Integer num:elements.keySet()){
            int parent=find(num);
            Element curr=elements.get(parent);
            if(curr.canFlip){
                int row=num/colNum;
                int col=num%colNum;
                board[row][col]='X';
            }
        }
    }

    private static void makeSet(char[][] board){
        int rowNum=board.length;
        int colNum=board[0].length;
        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                int curr=row*colNum+col;
                Element element=new Element(curr,curr);
                if(row==0||col==0||row==rowNum-1||col==colNum-1){
                    element.canFlip=false;
                }
                elements.put(curr,element);
            }
        }
    }
    private static void union(int num1,int num2){
        int parent1_name=find(num1);
        int parent2_name=find(num2);

        if(parent1_name==parent2_name)return;

        Element parent1=elements.get(parent1_name);
        Element parent2=elements.get(parent2_name);
        if(parent1.rank<parent2.rank){
            parent1.parent=parent2_name;
        }else if(parent1.rank>parent2.rank){
            parent2.parent=parent1_name;
        }else{
            parent1.parent=parent2_name;
            parent2.rank++;
        }

        parent1.canFlip&=parent2.canFlip;
        parent2.canFlip&=parent1.canFlip;
    }

    private static int find(int num){
        Element curr=elements.get(num);
        Element ele=curr;
        while(true){
            int parent_name=curr.parent;

            if(parent_name==curr.value){
                ele.parent=parent_name;
                return parent_name;
            }
            curr=elements.get(parent_name);
        }
    }
    //method2,先看边，如果靠边的是'O',那么BFS，将与其相邻的'O'都变成‘Y’.
    //在从到到位走一遍，这时的所有的‘O’都不会有与靠边的相邻了，这是的‘O’都变成‘X’,并将前面的‘Y’变回‘O’就行了。
    public static void solve1(char[][] board){
        if(board==null||board.length==0||board[0].length==0)return;
        int rowNum=board.length;
        int colNum=board[0].length;
        for (int row = 0; row < rowNum; row++) {
            if(board[row][0]=='o')BFS(board,row,0);
            if(board[row][colNum-1]=='o')BFS(board,row,colNum-1);
        }
        for (int col = 0; col < colNum; col++) {
            if(board[0][col]=='o')BFS(board,0,col);
            if(board[rowNum-1][col]=='o')BFS(board,rowNum-1,col);
        }

        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                if(board[row][col]=='o')board[row][col]='x';
                if(board[row][col]=='y')board[row][col]='o';
            }
        }

    }
    private static void BFS(char[][] board,int row,int col){
        board[row][col]='y';
        int rowNum=board.length;
        int colNum=board[0].length;
        int temp=row*colNum+col;
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(temp);
        while(!queue.isEmpty()){
            Integer curr=queue.poll();
            int r=curr/colNum;
            int c=curr%colNum;
            if(r+1<rowNum&&board[r+1][c]=='o')queue.offer((r+1)*colNum+c);
            if(r-1>=0&&board[r-1][c]=='o')queue.offer((r-1)*colNum+c);
            if(c+1<colNum&&board[r][c+1]=='o')queue.offer(r*colNum+c+1);
            if(c-1>=0&&board[r][c-1]=='o')queue.offer(r*colNum+c-1);
        }
    }
}
