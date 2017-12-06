package com.ccsi.leetcode1;


/**
 * Created by gxliu on 2017/12/4.
 * leetcode 130
 */
public class LC200NumberOfIslands {
    //method1 union-find
    public static void main(String[] args) {
        LC200NumberOfIslands uf=new LC200NumberOfIslands();
//        char[][] grid={{'1','1','1','1','0'},
//                {'1','1','0','1','0'},
//                {'1','1','0','0','0'},
//                {'0','0','0','0','0'}};
        char[][] grid={{'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};
        System.out.println(uf.numIslands(grid));
    }
    private class Point{
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public boolean equals(Point p){
            return this.row==p.row&&this.col==p.col;
        }
    }
    private class UfElement{
        Point key;
        Point parent;
        int rank;

        public UfElement(Point key, Point parent) {
            this.key = key;
            this.parent = parent;
            this.rank=0;
        }
    }
    private UfElement[][] elements;
    private int count=0;

    public int numIslands(char[][] grid){
        if(grid==null||grid.length==0||grid[0].length==0)return 0;
        int rowNum=grid.length;
        int colNum=grid[0].length;
        elements =new UfElement[rowNum][colNum];
        //makeSets
        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                if(grid[row][col]=='1'){
                    Point p=new Point(row,col);
                    elements[row][col]=new UfElement(p,p);
                    count++;
                }

            }
        }

        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                if(grid[row][col]=='1'){
                    if(row+1<rowNum&&grid[row+1][col]=='1')union(new Point(row,col),new Point(row+1,col));
                    if(col+1<colNum&&grid[row][col+1]=='1')union(new Point(row,col),new Point(row,col+1));
                }

            }
        }
        return count;
    }
    private void union(Point p1,Point p2){
        Point parent1=find(p1);
        Point parent2=find(p2);

        if(parent1.equals(parent2))return;

        UfElement ele1= elements[parent1.row][parent1.col];
        UfElement ele2= elements[parent2.row][parent2.col];

        if(ele1.rank<ele2.rank){
            ele1.parent=parent2;
        }else if(ele1.rank>ele2.rank){
            ele2.parent=parent1;
        }else{
            ele1.parent=parent2;
            ele2.rank++;
        }

        count--;
    }

    private Point find(Point p){
        UfElement curr= elements[p.row][p.col];
        UfElement temp=curr;

        while(true){
            Point parent=curr.parent;
            if(parent.equals(curr.key)){
                temp.parent=parent;
                return parent;
            }
            curr= elements[parent.row][parent.col];
        }
    }

}
