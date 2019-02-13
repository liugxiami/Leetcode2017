package com.ccsi.leetcode5;

public class LC576OutOfBoundayPaths {
    public static void main(String[] args) {
        System.out.println(findPaths(1,3,3,0,1));
    }
    //DP,三层循环，最外循环是N,内两循环是走grid，相当于是三维---一个立方体。不断更新没一层。
    public static int findPaths(int m,int n,int N,int i,int j){
        int[][] grid=new int[m][n];
        int paths=0;
        grid[i][j]=1; //第一层，只有i，j上是1，其他都是0
        int mod=1000000007;
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}}; //辅助数组，方便前后左右走
        for (int k = 0; k < N; k++) { //外层循环是总步数，走完N步都出不去就不再走了
            int[][] temp=new int[m][n]; //每近一步，生成一个新的grid
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) { //循环更新新grid里面的数字，代表走到当前格的路径数
                    for(int[] dir:dirs){
                        int nr=r+dir[0];
                        int nc=c+dir[1];
                        if(nr<0||nr>=m||nc<0||nc>=n)paths=(paths+grid[r][c])%mod;//如果走出去了
                        //将走出前grid的路径数累加进paths
                        else temp[nr][nc]=(temp[nr][nc]+grid[r][c])%mod;//否则，更新当前格中的路径数，
                        //就是加上走进当前格前一步的路径数。
                    }
                }
            }
            grid=temp;
        }
        return paths;
    }
}
