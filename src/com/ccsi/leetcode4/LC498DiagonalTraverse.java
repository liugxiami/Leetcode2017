package com.ccsi.leetcode4;

public class LC498DiagonalTraverse {
    public static void main(String[] args) {
        int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[] result=findDiagonalOrder(matrix);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
    public static int[] findDiagonalOrder(int[][] matrix){
        if(matrix==null||matrix.length==0||matrix[0].length==0)return new int[0];

        int rowNum=matrix.length;
        int colNum=matrix[0].length;
        int[] result=new int[rowNum*colNum];
        int row=0;
        int col=0;
        boolean up=true;
        for (int i = 0; i < rowNum * colNum; i++) {
            result[i]=matrix[row][col];
            if(up){
                if(col==colNum-1){ //注意这边的先后顺序问题，到右上角时，需要往下走
                    row++;
                    up=!up;
                }else if(row==0) {
                    col++;
                    up=!up;
                }else{
                    row--;
                    col++;
                }
            }else{
                if(row==rowNum-1) { //同样的问题.
                    col++;
                    up = !up;
                }
                else if(col==0){
                    row++;
                    up=!up;
                }else{
                    row++;
                    col--;
                }
            }
        }
        return result;
    }
}
