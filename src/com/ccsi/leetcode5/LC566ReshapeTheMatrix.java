package com.ccsi.leetcode5;

public class LC566ReshapeTheMatrix {
    public static void main(String[] args) {
        int[][] nums={{1,2},{3,4}};
        int[][] arr=matrixReshape(nums,1,4);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.println(arr[i][j]);
            }
        }
    }
    public static int[][] matrixReshape(int[][] nums,int r,int c){
        if(nums==null||nums.length==0||nums[0]==null||nums[0].length==0)return nums;
        int size=nums.length*nums[0].length;
        if(size!=r*c)return nums;
        int[][] newArray=new int[r][c];
        int row=0;
        int col=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                newArray[row][col++]=nums[i][j];
                if(col>=c){
                    row++;
                    col=0;
                }
            }
        }
        return newArray;
    }
}
