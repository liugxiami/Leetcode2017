package com.ccsi.leetcode3;

import java.util.TreeSet;

/**
 * Created by gxliu on 2018/3/29.
 */
public class LC363MaxSumOfRectangleNoLargerThanK {
    public static void main(String[] args) {
        //int[][] matrix={{5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4}};
        int[][] matrix={{1,0,1},{0,-2,3}};
        System.out.println(maxSumSubmatrix1(matrix,2));
    }
    //method1 brute-force O(N^4)
    public static int maxSumSubmatrix(int[][] matrix,int k){
        if(matrix==null||matrix.length==0||matrix[0]==null||matrix[0].length==0)return 0;
        int rowNum=matrix.length;
        int colNum=matrix[0].length;

        int[][] sum=new int[rowNum][colNum];
        int result=0;
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                int t=matrix[i][j];
                if(i>0)t+=sum[i-1][j];
                if(j>0)t+=sum[i][j-1];
                if(i>0&&j>0)t-=sum[i-1][j-1];
                sum[i][j]=t;

                for (int l = 0; l <= i; l++) {
                    for (int m = 0; m <= j; m++) {
                        int temp=sum[i][j];
                        if(l>0)temp-=sum[l-1][j];
                        if(m>0)temp-=sum[i][m-1];
                        if(l>0&&m>0)temp+=sum[l-1][m-1];

                        if(temp<=k)result=Math.max(result,temp);
                        if(result==k)return k;
                    }
                }
            }
        }
        return result;
    }
    //method2 用一个treeSet来加快 O(N^3 logN)
    public static int maxSumSubmatrix1(int[][] matrix,int k){
        if(matrix==null||matrix.length==0||matrix[0]==null||matrix[0].length==0)return Integer.MIN_VALUE;
        int rowNum=matrix.length;
        int colNum=matrix[0].length;

        int result=Integer.MIN_VALUE;
        for (int col = 0; col < colNum; col++) { //起始位置，[0,0],[0,1]...
            int[] rowSum=new int[rowNum]; //每次从新的起始位点开始都要用一个新的一维数组来缓存，每行的和
            for (int j = col; j < colNum; j++) {
                TreeSet<Integer> set=new TreeSet<>(); //为了查找方便，O[logn],从起始点开始的累积
                set.add(0);
                int curr=0;
                for (int i = 0; i < rowNum; i++) {
                    rowSum[i]= rowSum[i]+matrix[i][j];
                    curr+=rowSum[i];

                    Integer temp=set.ceiling(curr-k); //不存在的话会返回null值。
                    if(temp!=null){
                        result=Math.max(result,curr-temp);
                    }
                    set.add(curr);
                }
            }
        }
        return result;
    }
}
