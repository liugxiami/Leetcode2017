package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/10/8.
 */
public class LC074Search2DMatrix {
    public static void main(String[] args) {
        int[][] matrix={{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        System.out.println(searchMatrix(matrix,51));
    }
    //从左下角开始，target小的话往上走，大的话往右走。也可以从右上角开始，target大的话往下走，小的话往左走。走出循环了，说明找不到。
    public static boolean searchMatrix(int[][] matrix,int target){
        if(matrix==null||matrix.length==0||matrix[0].length==0)return false;
        int rowNum=matrix.length;
        int colNum=matrix[0].length;

        int row=rowNum-1;
        int col=0;
        while(row>=0&&col<colNum){
            if(target==matrix[row][col])return true;
            if(target<matrix[row][col])row--;
            else col++;
        }
        return false;
    }
}
