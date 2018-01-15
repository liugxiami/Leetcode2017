package com.ccsi.leetcode2;

/**
 * Created by gxliu on 2018/1/14.
 */
public class LC304RangeSumQuery2D {
    private int[][] sumMaxtrix;
    //Method1 用#303相似的方法，但在sumRegion的时间复杂度是O（m x n）,其中m=row2-row1+1,n=col2-col1+1
    //不够好。
//    public LC304RangeSumQuery2D(int[][] maxtrix){
//        if(maxtrix==null||maxtrix.length==0||maxtrix[0].length==0)return;
//        int rowNum=maxtrix.length;
//        int colNum=maxtrix[0].length;
//        sumMaxtrix=new int[rowNum][colNum];
//        for (int row = 0; row < rowNum; row++) {
//            for (int col = 0; col < colNum; col++) {
//                if(col==0)sumMaxtrix[row][col]=maxtrix[row][col];
//                else{
//                    sumMaxtrix[row][col]=sumMaxtrix[row][col-1]+maxtrix[row][col];
//                }
//            }
//        }
//    }
//    public int sumRegion(int row1,int col1,int row2,int col2){
//        if(row1<0||col1<0||row1>row2||col1>col2||row2>=sumMaxtrix.length||
//                col2>=sumMaxtrix[0].length)return Integer.MIN_VALUE;
//        int sum=0;
//        if(col1==0){
//            for (int row = row1; row <=row2; row++) {
//                sum+=sumMaxtrix[row][col2];
//            }
//        }else{
//            for (int row = row1; row <=row2; row++) {
//                sum+=sumMaxtrix[row][col2]-sumMaxtrix[row][col1-1];
//            }
//        }
//        return sum;
//    }
    //Method2,利用矩形面积重叠的方法来计算。sumMatrix的意义不同前，这里是[0,0]到[i,j]这个矩形的面积。
    public LC304RangeSumQuery2D(int[][] matrix){
        if(matrix==null||matrix.length==0||matrix[0].length==0)return;
        int rowNum=matrix.length;
        int colNum=matrix[0].length;
        sumMaxtrix=new int[rowNum][colNum];
        sumMaxtrix[0][0]=matrix[0][0];
        for (int row = 1; row < rowNum; row++) {
            sumMaxtrix[row][0]=sumMaxtrix[row-1][0]+matrix[row][0];
        }
        for (int col = 1; col < colNum; col++) {
            sumMaxtrix[0][col]=sumMaxtrix[0][col-1]+matrix[0][col];
        }

        for (int row = 1; row < rowNum; row++) {
            for (int col = 1; col < colNum; col++) {
                sumMaxtrix[row][col]=sumMaxtrix[row-1][col]+sumMaxtrix[row][col-1]-
                        sumMaxtrix[row-1][col-1]+matrix[row][col];
            }
        }
    }
    public int sumRegion(int row1,int col1,int row2,int col2){
        if(row1<0||col1<0||row1>row2||col1>col2||row2>=sumMaxtrix.length||
                col2>=sumMaxtrix[0].length)return Integer.MIN_VALUE;

        if(row1==0&&col1==0)return sumMaxtrix[row2][col2];
        else if(row1==0)return sumMaxtrix[row2][col2]-sumMaxtrix[row2][col1-1];
        else if(col1==0)return sumMaxtrix[row2][col2]-sumMaxtrix[row1-1][col2];
        else return sumMaxtrix[row2][col2]-sumMaxtrix[row1-1][col2]-sumMaxtrix[row2][col1-1]+
                sumMaxtrix[row1-1][col1-1];
    }
    public static void main(String[] args) {
//        int[][] matrix={
//                {3, 0, 1, 4, 2},
//                {5, 6, 3, 2, 1},
//                {1, 2, 0, 1, 5},
//                {4, 1, 0, 1, 7},
//                {1, 0, 3, 0, 5}
//        };
        int[][] matrix={{1},{-7}};
        LC304RangeSumQuery2D rigion=new LC304RangeSumQuery2D(matrix);
        System.out.println(rigion.sumRegion(0,0,0,0));
        System.out.println(rigion.sumRegion(1,0,1,0));
        System.out.println(rigion.sumRegion(0,0,1,0));
    }
}
