package com.ccsi.leetcode5;

import java.util.*;

public class LC54201Matrix {
    public static void main(String[] args) {
        int[][] matrix={{0,1,0,1,1},{1,1,0,0,1},{0,0,0,1,0},{1,0,1,1,1},{1,0,0,0,1}};
        int[][] res=updateMatrix1(matrix);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }
    //method1 循环+BFS，双queue，计算层。Time Limit Exceeded
    public static int[][] updateMatrix(int[][] matrix){
        if(matrix==null||matrix.length==0||matrix[0]==null||matrix[0].length==0)return matrix;
        int rowNum=matrix.length;
        int colNum=matrix[0].length;
        for (int r = 0; r < rowNum; r++) {
            for (int c = 0; c < colNum; c++) {
                if(matrix[r][c]==0)continue;
                matrix[r][c]=nearestBFS(matrix,r,c);
            }
        }
        return matrix;
    }
    private static int nearestBFS(int[][] matrix,int row,int col){
        boolean[][] visited=new boolean[matrix.length][matrix[0].length];
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{row,col});
        visited[row][col]=true;
        int level=0;
        int[][] dirs={{-1,0},{1,0},{0,-1},{0,1}};
        while(!queue.isEmpty()){
            Queue<int[]> next=new LinkedList<>();
            while(!queue.isEmpty()){
                int[] curr=queue.poll();
                if(matrix[curr[0]][curr[1]]==0)return level;
                for(int[] d:dirs){
                    int r= curr[0]+d[0];
                    int c= curr[1]+d[1];
                    if(r>=0&&r<matrix.length&&c>=0&&c<matrix[0].length&&!visited[r][c]){
                        next.offer(new int[]{r,c});
                        visited[r][c]=true;
                    }
                }
            }
            level++;
            queue=next;
        }
        return level;
    }
    // method2 参考了discussion.首先遍历一次矩阵，将值为0的点都存入queue，将值为1的点改为INT_MAX。之前像什么遍历迷宫啊，起点只有一个，
    // 而这道题所有为0的点都是起点，这想法，叼！然后开始BFS遍历，从queue中取出一个数字，遍历其周围四个点，如果越界或者周围点的值小于等于当前值，
    // 则直接跳过。因为周围点的距离更小的话，就没有更新的必要，否则将周围点的值更新为当前值加1，然后把周围点的坐标加入queue，
    public static int[][] updateMatrix1(int[][] matrix){
        if(matrix==null||matrix.length==0||matrix[0]==null||matrix[0].length==0)return matrix;
        int rowNum=matrix.length;
        int colNum=matrix[0].length;
        Queue<int[]> queue=new LinkedList<>();
        for (int r = 0; r < rowNum; r++) {
            for (int c = 0; c < colNum; c++) {
                if(matrix[r][c]==0)queue.offer(new int[]{r,c});
                else matrix[r][c]=Integer.MAX_VALUE;
            }
        }
        int[][] dirs={{1,0},{-1,0},{0,-1},{0,1}};
        while(!queue.isEmpty()){
            int[] temp=queue.poll();
            for(int[] d:dirs){
                int r=temp[0]+d[0];
                int c=temp[1]+d[1];
                if(r<0||r>=rowNum||c<0||c>=colNum)continue;
                if(matrix[r][c]<=matrix[temp[0]][temp[1]])continue;
                matrix[r][c]=matrix[temp[0]][temp[1]]+1;
                queue.offer(new int[]{r,c});
            }
        }
        return matrix;
    }
}
