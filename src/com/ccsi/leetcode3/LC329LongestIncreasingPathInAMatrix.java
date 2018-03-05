package com.ccsi.leetcode3;

import java.util.*;

/**
 * Created by gxliu on 2018/2/27.
 */
public class LC329LongestIncreasingPathInAMatrix {
    public static void main(String[] args) {
        int[][] matrix={{9,9,4},
                {6,6,8},{2,1,0}};
        System.out.println(longestIncreasingPath1(matrix));
    }
    //method 1, loop+BFS, Time Limit exceeded
    private static int max=0;
    public static int longestIncreasingPath(int[][] matrix){
        if(matrix==null||matrix.length==0||matrix[0].length==0)return 0;
        int rowNum=matrix.length;
        int colNum=matrix[0].length;
        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                bfs(matrix,row,col,rowNum,colNum);
            }
        }
        return max;
    }
    private static void bfs(int[][] matrix,int row,int col,int rowNum,int colNum){
        Queue<Integer[]> queue=new LinkedList<>();
        queue.offer(new Integer[]{row,col});
        int layer=0;
        while(!queue.isEmpty()){
            Queue<Integer[]> next=new LinkedList<>();
            while(!queue.isEmpty()){
                Integer[] curr=queue.poll();
                int temp=matrix[curr[0]][curr[1]];
                if(curr[0]+1<rowNum&&matrix[curr[0]+1][curr[1]]<temp)next.offer(new Integer[]{curr[0]+1,curr[1]});
                if(curr[0]-1>=0&&matrix[curr[0]-1][curr[1]]<temp)next.offer(new Integer[]{curr[0]-1,curr[1]});
                if(curr[1]+1<colNum&&matrix[curr[0]][curr[1]+1]<temp)next.offer(new Integer[]{curr[0],curr[1]+1});
                if(curr[1]-1>=0&&matrix[curr[0]][curr[1]-1]<temp)next.offer(new Integer[]{curr[0],curr[1]-1});
            }
            queue=next;
            layer++;
        }
        max=Math.max(max,layer);
    }
    //method 2 loop+ DFS with cache.
    private static int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
    public static int longestIncreasingPath1(int[][] matrix){
        if(matrix==null||matrix.length==0||matrix[0].length==0)return 0;
        int rowNum=matrix.length;
        int colNum=matrix[0].length;
        int[][] cache=new int[rowNum][colNum];
        int max=1;
        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                int len=dfs(matrix,row,col,rowNum,colNum,cache);
                max=Math.max(max,len);
            }
        }
        return max;
    }
    private static int dfs(int[][] matrix,int row,int col,int rowNum,int colNum,int[][] cache){
        if(cache[row][col]!=0)return cache[row][col];

        int max=1;
        for (int i = 0; i < 4; i++) {
            int x=row-dir[i][0];
            int y=col-dir[i][1];
            if(x<0||x>=rowNum||y<0||y>=colNum||matrix[x][y]>=matrix[row][col])continue;
            int len=1+dfs(matrix,x,y,rowNum,colNum,cache);
            max=Math.max(max,len);
        }
        cache[row][col]=max;

        return max;
    }
}
