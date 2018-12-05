package com.ccsi.leetcode5;

import java.util.zip.CheckedOutputStream;

public class LC526BeautifulArrangement {
    public static void main(String[] args) {
        for (int i = 0; i <=15; i++) {
            System.out.println(countArrangement(i));
        }
    }
    private static int count;
    public static int countArrangement(int N){
        if(N==0)return 0;
        count=0;
        backTracking(N,1,new boolean[N+1]);
        return count;
    }
    private static void backTracking(int N, int index,boolean[] visited){
        if(index>N){
            count++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            if(!visited[i]&&(i%index==0||index%i==0)){
                visited[i]=true;
                backTracking(N,index+1,visited);
                visited[i]=false;
            }
        }
    }
}
