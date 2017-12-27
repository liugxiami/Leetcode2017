package com.ccsi.leetcode2;

/**
 * Created by gxliu on 2017/12/26.
 */
public class LC240SearchA2DMatrixII {
    public static void main(String[] args) {
        int[][] matrix= {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        //int[][] matrix={{1,1}};
        System.out.println(searchMatrix(matrix,5));
    }
    public static boolean searchMatrix(int[][] matrix,int target){
        if(matrix==null||matrix.length==0||matrix[0].length==0)return false;
        int rowNum=matrix.length;
        int colNum=matrix[0].length;

        int left=0;
        int bottom=rowNum-1;
        while(left<colNum&&bottom>=0){
            if(target==matrix[bottom][left])return true;
            else if(target>matrix[bottom][left])left++;
            else bottom--;
        }
        return false;
    }
}
