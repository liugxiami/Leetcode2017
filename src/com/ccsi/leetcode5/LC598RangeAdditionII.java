package com.ccsi.leetcode5;

public class LC598RangeAdditionII {
    public static void main(String[] args) {
        System.out.println(maxCount(3,3,new int[][]{new int[]{2,2},new int[]{3,3}}));
    }
    public static int maxCount(int m,int n,int[][] ops){
        if(ops==null||ops.length==0)return m*n;
        int minRow=ops[0][0];
        int minCol=ops[0][1];
        for (int i = 1; i < ops.length; i++) {
            minRow=Math.min(minRow,ops[i][0]);
            minCol=Math.min(minCol,ops[i][1]);
        }
        return minCol*minRow;
    }
}
