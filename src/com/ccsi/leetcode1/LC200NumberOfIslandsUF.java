package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/12/5.
 */
public class LC200NumberOfIslandsUF {
    private class Point{
        int key;
        int parent;
        int rank;
        public Point(int k,int p){
            this.key=k;
            this.parent=p;
            this.rank=0;
        }
    }
    private Map<Integer, Point> map=new HashMap<>();
    private int count=0;

    public int numIslands(char[][] grid){
        if(grid==null||grid.length==0||grid[0].length==0)return 0;
        int rowNum=grid.length;
        int colNum=grid[0].length;

        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                if(grid[row][col]=='1'){
                    int temp=row*colNum+col;
                    map.put(temp,new Point(temp,temp));
                    count++;
                }
            }
        }

        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                if(grid[row][col]=='1'){
                    if(row+1<rowNum&&grid[row+1][col]=='1')union(row*colNum+col,(row+1)*colNum+col);
                    if(row-1>=0&&grid[row-1][col]=='1')union(row*colNum+col,(row-1)*colNum+col);
                    if(col+1<colNum&&grid[row][col+1]=='1')union(row*colNum+col,row*colNum+col+1);
                    if(col-1>=0&&grid[row][col-1]=='1')union(row*colNum+col,row*colNum+col-1);
                }
            }
        }
        return count;
    }
    private void union(int p,int q){
        int parent1=find(p);
        int parent2=find(q);
        if(parent1==parent2)return;

        Point pParent=map.get(parent1);
        Point qParent=map.get(parent2);

        if(pParent.rank<qParent.rank){
            pParent.parent=parent2;
        }else if(pParent.rank<qParent.rank){
            qParent.parent=parent1;
        }else{
            pParent.parent=parent2;
            qParent.rank++;
        }
        count--;
    }

    private int find(int p){
        Point curr=map.get(p);
        Point temp=curr;

        while(true){
            int parent=curr.parent;
            if(parent==curr.key){
                temp.parent=parent;
                return parent;
            }
            curr=map.get(parent);
        }
    }

    public static void main(String[] args) {
        LC200NumberOfIslandsUF find=new LC200NumberOfIslandsUF();
//        char[][] grid={{'1','1','1','1','0'},
//                {'1','1','0','1','0'},
//                {'1','1','0','0','0'},
//                {'0','0','0','0','0'}};
        char[][] grid={{'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};
        System.out.println(find.numIslands(grid));
    }
}
