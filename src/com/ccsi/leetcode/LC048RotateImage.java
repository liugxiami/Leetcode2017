package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/9/23.
 */
public class LC048RotateImage {
    public static void main(String[] args) {
        int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotate1(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.printf("%d ",matrix[i][j]);
            }
            System.out.println();
        }
    }
    //方法1：最直观的做法，找到新matrix与旧matrix的坐标关系，新的（i，j）=旧的（len-j，i）。
    public static void rotate(int[][] matrix){
        if(matrix==null||matrix.length==0||matrix[0].length==0)return;
        int pRow=matrix.length;
        int pCol=matrix[0].length;
        if(pRow!=pCol)return;
        int len=pRow;
        int[][] result=new int[len][len];

        for (int row = 0; row < len; row++) {
            for (int col = 0; col < len; col++) {
                result[row][col]=matrix[len-1-col][row];
            }
        }

        for (int row = 0; row < len; row++) {
            for (int col = 0; col < len; col++) {
                matrix[row][col]=result[row][col];
            }
        }
    }
    //方法二：题目的要求是不能新建matrix，那还是要找坐标之间的关系。也就是说，只用空间复杂度O（1）的情况下来解决问题，画图，旋转90度
    //各坐标之间的关系，(i,j)->(j,len-1-i)->(len-1-i,len-1-j)->(len-1-i,j)->(i,j).设计好两个循环
    public static void rotate1(int[][] matrix){
        if(matrix==null||matrix.length==0||matrix[0].length==0)return;
        if(matrix.length!=matrix[0].length)return;
        int len=matrix.length;
        for (int row = 0; row <= (len-1)/2; row++) { //这边的row<=必须是max index/2，不是len/2.
            for (int col = row; col < len-1-row; col++) {  //每走一圈，其步数是highindex-1，row的增加，内圈就越短
                int temp=matrix[row][col];
                matrix[row][col]=matrix[len-1-col][row];
                matrix[len-1-col][row]=matrix[len-1-row][len-1-col];
                matrix[len-1-row][len-1-col]=matrix[col][len-1-row];
                matrix[col][len-1-row]=temp;
            }
        }
    }
}
