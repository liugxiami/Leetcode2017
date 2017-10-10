package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/10/8.
 */
public class LC073SetMatrixZeros {
    public static void main(String[] args) {
        int[][] matrix={{5,4,3,2,1},{3,4,0,2,1},{3,0,2,1,1},{0,1,1,1,1},{1,2,3,4,5}};
        setZeroes1(matrix);
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col]+" ");
            }
            System.out.println();
        }
    }
    //method1,利用了两个数组来记录
    public static void setZeroes(int[][] matrix){
        if(matrix==null||matrix.length==0||matrix[0].length==0)return;
        int rowNum=matrix.length;
        int colNum=matrix[0].length;

        boolean[] hasRow=new boolean[rowNum];
        boolean[] hasCol=new boolean[colNum];
        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                if(matrix[row][col]==0){
                    hasRow[row]=true;
                    hasCol[col]=true;
                }
            }
        }

        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                if(hasRow[row]||hasCol[col]){
                    matrix[row][col]=0;
                }
            }
        }
    }
    //method2，直接利用第一行和第一列来记录，需要注意的是，我们需从第二个元素开始做，最后来检查是否让第一行和第一列归0
    public static void setZeroes1(int[][] matrix){
        if(matrix==null||matrix.length==0||matrix[0].length==0)return;
        int rowNum=matrix.length;
        int colNum=matrix[0].length;

        boolean firstRow=false;
        for (int i = 0; i < colNum; i++) {
            if(matrix[0][i]==0)firstRow=true;
        }

        boolean firstCol=false;
        for (int i = 0; i < rowNum; i++) {
            if(matrix[i][0]==0)firstCol=true;
        }

        for (int row = 1; row < rowNum; row++) {
            for (int col = 1; col < colNum; col++) {
                if(matrix[row][col]==0){
                    matrix[row][0]=0;
                    matrix[0][col]=0;
                }
            }
        }

        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                if(matrix[row][0]==0)matrix[row][col]=0;
                if(matrix[0][col]==0)matrix[row][col]=0;
            }
        }

        if(firstRow){
            for (int i = 0; i < colNum; i++) {
                matrix[0][i]=0;
            }
        }

        if(firstCol){
            for (int i = 0; i < rowNum; i++) {
                matrix[i][0]=0;
            }
        }
    }
}
