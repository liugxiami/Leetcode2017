package com.ccsi.leetcode5;

import java.util.*;

public class LC547FriendCircles {
    public static void main(String[] args) {
        int[][] M={{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        System.out.println(findCircleNum(M));
    }
    //Method1 loop+BFS，这个方法不行,TLE。int[][] M={{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}}就不行了
    public static int findCircleNum(int[][] M){
        if(M==null||M.length==0||M[0]==null||M[0].length==0)return 0;
        int rowNum=M.length;
        int colNum=M[0].length;
        int count=0;
        for (int r = 0; r < rowNum; r++) {
            for (int c = 0; c < colNum; c++) {
                if(M[r][c]==1){
                    count++;
                    BFS(M,r,c);
                }
            }
        }
        return count;
    }
    private static void BFS(int[][] M,int row,int col){
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{row,col});
        while(!queue.isEmpty()){
            int[] curr=queue.poll();
            int r=curr[0];
            int c=curr[1];
            M[r][c]=2;
            M[c][r]=2;
            for (int i = 0; i < M.length; i++) {
                if(M[r][i]==1)queue.offer(new int[]{r,i});
                if(M[c][i]==1)queue.offer(new int[]{c,i});
            }
        }
    }
    //Method2 unionFind
    public static int findCircleNum1(int[][] M){
        if(M==null||M.length==0||M[0]==null||M[0].length==0)return 0;
        makeSet(M);
        for (int r = 0; r < M.length; r++) {
            for (int c = 0; c < M[0].length; c++) {
                if(M[r][c]==1&&r!=c)union(r,c);
            }
        }
        int count=0;
        for(Map.Entry<Integer,UFElement> entry:UFElements.entrySet()){
            if(entry.getKey()==entry.getValue().parent)count++;
        }
        return count;
    }
    public static class UFElement{
        int name;
        int parent;
        int rank=0;
        public UFElement(int name,int parent){
            this.name=name;
            this.parent=parent;
        }
    }
    private static Map<Integer,UFElement> UFElements;
    private static void makeSet(int[][] M) {
        UFElements = new HashMap<>();
        for (int i = 0; i < M.length; i++) {
            if (!UFElements.containsKey(i)) {
                UFElements.put(i, new UFElement(i, i));
            }
        }
    }
    private static void union(int element1,int element2){
        int parent1=find(element1);
        int parent2=find(element2);
        if(parent1!=parent2){
            UFElement point1=UFElements.get(parent1);
            UFElement point2=UFElements.get(parent2);
            if(point1.rank<point2.rank){
                point1.parent=parent2;
            }else if(point1.rank>point2.rank){
                point2.parent=parent1;
            }else{
                point1.parent=parent2;
                point2.rank++;
            }
        }

    }
    private static int find(int element){
        UFElement point=UFElements.get(element);
        while(true){
            int parent=point.parent;
            if(point.name==parent){
                return parent;
            }
            point=UFElements.get(parent);
        }
    }

}
