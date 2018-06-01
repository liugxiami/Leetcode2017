package com.ccsi.leetcode4;

import java.util.*;

/**
 * Created by gxliu on 2018/5/30.
 */
public class LC417PacificAltanticWaterFlow {
    public static void main(String[] args) {
        int[][] matrix={{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<int[]> result=pacificAtlantic(matrix);
        for(int[] coordinate:result){
            System.out.printf(coordinate[0]+" "+ coordinate[1]);
            System.out.println();
        }
    }
    public static List<int[]> pacificAtlantic(int[][] matrix){
        List<int[]> result=new ArrayList<>();
        if(matrix==null||matrix.length==0||matrix[0].length==0)return result;
        int rowNum=matrix.length;
        int colNum=matrix[0].length;
        boolean[][] pacific=new boolean[rowNum][colNum];
        boolean[][] atlantic=new boolean[rowNum][colNum];

        for (int row = 0; row < rowNum; row++) {
            flow(pacific,matrix,row,0);
            flow(atlantic,matrix,row,colNum-1);
        }

        for(int col=0;col<colNum;col++){
            flow(pacific,matrix,0,col);
            flow(atlantic,matrix,rowNum-1,col);
        }

        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                if(pacific[row][col]&&atlantic[row][col]){
                    result.add(new int[]{row,col});
                }
            }
        }

        return result;
    }
    private static void flow(boolean[][] visited,int[][] matrix,int row,int col){
        visited[row][col]=true;
        int[] x={0,0,1,-1};
        int[] y={1,-1,0,0};
        for (int i = 0; i < 4; i++) {
            int r=row+x[i];
            int c=col+y[i];
            if(r>=0&&r<matrix.length&&c>=0&c<matrix[0].length&&matrix[r][c]>=matrix[row][col]&&!visited[r][c]){
                flow(visited,matrix,r,c);
            }
        }
    }
}
