package com.ccsi.leetcode2;

/**
 * Created by gxliu on 2017/12/16.
 */
public class LC221MaximalSquare {
    public static void main(String[] args) {
        char[][] matrix={{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        System.out.println(maximalSquareDP(matrix));
    }
    //method1，需要一个辅助函数来判断是否是正方形，传进的值是左上角的坐标，已经边长，如果任何一个元素不是1就返回false，否则是true。
    //主函数中，对每一个点迭代，如果碰到是1的点，就看看其右边已经下面还有几个点，找较小的一边作为最大边长，在一个循环从1到这个边长来一一
    //判断是否是正方形，是就跟最大边长比较，存下下大的。其中可以用两个参数来优化算法，一是：在最内的循环中用一个canContinue，另一个就是
    //比较已有的最大边与可能的最大边比较，如果已有的最大边都大于可能的最大边了，就不做计算直接找下一个点了。
    //算法复杂度O(N^3)?
    public static int maximalSquare(char[][] matrix){
        if(matrix==null||matrix.length==0||matrix[0].length==0)return 0;
        int rowNum=matrix.length;
        int colNum=matrix[0].length;
        int maxEdge=0;
        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                if(matrix[row][col]=='1'){
                    int maxLen=Math.min(rowNum-row,colNum-col);
                    if(maxLen<maxEdge-1)continue;
                    for (int len = 1; len < maxLen; len++) {
                        boolean canContinue=true;
                        if(isSquare(matrix,row,col,len)){
                            maxEdge=Math.max(maxEdge,len+1);
                        }else canContinue=false;

                        if(!canContinue)break;
                    }
                }
            }
        }
        return maxEdge*maxEdge;
    }
    private static boolean isSquare(char[][] matrix,int row,int col,int len){
        for (int i = row; i <= row+len; i++) {
            for (int j = col; j <= col + len; j++) {
                if(matrix[i][j]!='1')return false;
            }
        }
        return true;
    }
    //method2 DP（找最值，能否做常用DP），关键是怎么找状态方程。
    //f(i,j)=Min(Min(f(i-1,j),f(i,j-1)),f(i-1,j-1))+1;
    public static int maximalSquareDP(char[][] matrix){
        if(matrix==null||matrix.length==0||matrix[0].length==0)return 0;
        int rowNum=matrix.length;
        int colNum=matrix[0].length;
        int[][] cache=new int[rowNum][colNum];
        int max=0;

        //initiate
        for (int row = 0; row < rowNum; row++) {
            cache[row][0]=matrix[row][0]-'0';
            max=Math.max(max,cache[row][0]);
        }
        for (int col = 0; col < colNum; col++) {
            cache[0][col]=matrix[0][col]-'0';
            max=Math.max(max,cache[0][col]);
        }
        //for loop
        for (int row = 1; row < rowNum; row++) {
            for (int col = 1; col < colNum; col++) {
                if(matrix[row][col]=='0')cache[row][col]=0;
                else{
                    int left=cache[row][col-1];
                    int up=cache[row-1][col];
                    int upLeft=cache[row-1][col];

                    int min=Math.min(left,up);
                    min=Math.min(min,upLeft);
                    cache[row][col]=min+1;
                    max=Math.max(max,cache[row][col]);
                }
            }
        }
        return max*max;
    }
}
