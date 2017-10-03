package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/10/2.
 */
public class LC062UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths1(3,4));
    }

    //空间复杂度为O()
    public static int uniquePaths(int m,int n){
        if(m<1||n<1)return 1;
        int[][] cache=new int[m][n];
        for (int row = 0; row < m; row++) {
            cache[row][0]=1;
        }

        for (int col = 0; col < n; col++) {
            cache[0][col]=1;
        }

        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                cache[row][col]=cache[row-1][col]+cache[row][col-1];
            }
        }

        return cache[m-1][n-1];
    }

    //优化O(n)
    public static int uniquePaths1(int m,int n){
        if(m<1||n<1)return 1;
        int[] cache=new int[n];
        for (int col = 0; col < n; col++) {
            cache[col]=1;
        }

        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                cache[col]+=cache[col-1];
            }
        }
        return cache[n-1];
    }
}
