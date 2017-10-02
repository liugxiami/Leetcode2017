package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/10/1.
 */
public class LC059SpiralMatrixII {
    public static void main(String[] args) {
        int n=0;
        int[][] res=generateMatrix(n);
        for (int row = 0; row < res.length; row++) {
            for (int col = 0; col < res[0].length; col++) {
                System.out.print(res[row][col]+" ");
            }
            System.out.println();
        }
    }
    public static int[][] generateMatrix(int n){
        if(n<=0)return new int[0][0];
        int[][] matrix=new int[n][n];
        int left=0,right=n-1,top=0,bottom=n-1;
        int count=1;

        while (true){
            for (int i = left; i <= right; i++) {
                matrix[top][i]=count++;
            }
            if(++top>bottom)break;

            for (int i = top; i <= bottom; i++) {
                matrix[i][right]=count++;
            }

            if(--right<left)break;

            for (int i = right; i >=left; i--) {
                matrix[bottom][i]=count++;
            }
            if(--bottom<top)break;

            for (int i = bottom; i >=top ; i--) {
                matrix[i][left]=count++;
            }
            if(++left>right)break;
        }

        return matrix;
    }
}
