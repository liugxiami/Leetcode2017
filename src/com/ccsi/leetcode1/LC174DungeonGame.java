package com.ccsi.leetcode1;

/**
 * Created by gxliu on 2017/11/30.
 */
public class LC174DungeonGame {
    public static void main(String[] args) {
        int[][] dungeon={{0,0}};
        System.out.println(calculateMinimumHP(dungeon));
    }
    public static int calculateMinimumHP(int[][] dungeon){
        if(dungeon==null||dungeon.length==0||dungeon[0].length==0)return 1;
        int rowNum=dungeon.length;
        int colNum=dungeon[0].length;
        //定义一个缓存
        int[][] cache=new int[rowNum][colNum]; //表示进入[row][col]之前应该有的生命值，必须>=1.
        //计算时： x+dungeon[i][j]=Math.min(cache[i+1][j],cache[i][j+1])并且>=1.
        //初始化，与minimun或maximum path不同的是，这题是从末尾（右下角往左上角走）。
        cache[rowNum-1][colNum-1]=Math.max(1-dungeon[rowNum-1][colNum-1],1);

        for (int row = rowNum-2; row >=0; row--) {
            cache[row][colNum-1]=Math.max(cache[row+1][colNum-1]-dungeon[row][colNum-1],1);
        }
        for (int col=colNum-2;col>=0;col--){
            cache[rowNum-1][col]=Math.max(cache[rowNum-1][col+1]-dungeon[rowNum-1][col],1);
        }
        //合适的循环

        for (int row = rowNum-2; row >=0 ; row--) {
            for (int col = colNum-2; col >=0 ; col--) {
                int temp=Math.min(cache[row+1][col],cache[row][col+1]);
                cache[row][col]=Math.max(temp-dungeon[row][col],1);
            }
        }

        return cache[0][0];
    }
}
