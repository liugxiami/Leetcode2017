package com.ccsi.tests;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gxliu on 2017/9/18.
 */
public class findObjects {
    public static void main(String[] args) {
        int[][] graph=buildGraph();
        System.out.println(findObjectsBFS(graph));
    }

    public static int findObjects(int[][] graph){
        if(graph==null||graph.length==0||graph[0].length==0)return 0;
        int count=0;
        for (int row = 0; row < graph.length; row++) {
            for (int col = 0; col < graph[0].length; col++) {
                if(graph[row][col]==1){
                    count++;
                    findDfs(graph,row,col);
                }
            }
        }
        return count;
    }
    public static void findDfs(int[][] graph,int row,int col){
        if(row<0||row==graph.length||col<0||col==graph[0].length)return;

        if(graph[row][col]==1) {  //只有在符合条件的情况下，对上下左右进行递归操作
            graph[row][col]=2;
            findDfs(graph,row+1,col);
            findDfs(graph,row-1,col);
            findDfs(graph,row,col+1);
            findDfs(graph,row,col-1);
        }
    }
    public static int findObjectsBFS(int[][] graph){
        if(graph==null|graph.length==0||graph[0].length==0)return 0;
        int count=0;
        Queue<int[]> queue=new LinkedList<>();
        for (int row = 0; row < graph.length; row++) {
            for (int col = 0; col < graph[0].length; col++) {
                if(graph[row][col]==1){
                    count++;
                    int[] cur={row,col};
                    queue.offer(cur);
                    while(!queue.isEmpty()){
                        int[] temp=queue.poll();
                        int tRow=temp[0];
                        int tCol=temp[1];
                        graph[tRow][tCol]=2;//放在此处可以省几行代码

                        //对该坐标的上下左右进行判断并入queue
                        if(tRow+1>=0&&tRow+1<graph.length&&graph[tRow+1][tCol]==1){
                            int[] pair={tRow+1,tCol};
                            queue.offer(pair);
                        }

                        if(tRow-1>=0&&tRow-1<graph.length&&graph[tRow-1][tCol]==1){
                            int[] pair={tRow-1,tCol};
                            queue.offer(pair);
                        }

                        if(tCol+1>=0&&tCol+1<graph[0].length&&graph[tRow][tCol+1]==1){
                            int[] pair={tRow,tCol+1};
                            queue.offer(pair);
                        }

                        if(tCol-1>=0&&tCol-1<graph[0].length&&graph[tRow][tCol-1]==1){
                            int[] pair={tRow,tCol-1};
                            queue.offer(pair);
                        }
                    }
                }
            }
        }
        return count;
    }
    public static int[][] buildGraph(){
        int[][] graph=new int[10][10];
        for (int i = 2; i < 6; i++) {
            graph[2][i]=1;
            graph[6][i]=1;

            graph[i][2]=1;
            graph[i][6]=1;
        }

        for (int i = 4; i < 8; i++) {
            graph[4][i]=1;
            graph[8][i]=1;

            graph[i][4]=1;
            graph[i][8]=1;
        }

        graph[9][9]=1;
        graph[8][9]=1;
        return graph;
    }
}
