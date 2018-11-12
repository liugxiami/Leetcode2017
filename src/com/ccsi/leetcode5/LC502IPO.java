package com.ccsi.leetcode5;

import java.util.*;

public class LC502IPO {
    public static void main(String[] args) {
        int k=2;
        int w=0;
        int[] profits={2,1,3};
        int[] capital={1,0,1};
        System.out.println(findMaximizedCapital1(k,w,profits,capital));
    }
    private static int max=0;
    public static int findMaximizedCapital(int k,int w,int[] Profits,int[] Capital){
        boolean[] visited=new boolean[Profits.length];
        maximize(k,w,Profits,Capital,visited,0);
        return max;
    }
    private static void maximize(int k,int w,int[] Profits,int[] Captital,boolean[] visited,int count){
        for (int i = 0; i < Profits.length; i++) {
            if(!visited[i]){
                if(Captital[i]>w)continue;
                w+=Profits[i];
                visited[i]=true;
                count++;
                if(count==k){
                    max=max>w?max:w;
                    return;
                }
                maximize(k,w,Profits,Captital,visited,count);
                visited[i]=false;
            }
        }
    }
    //greedy 用两个prorityQueue，按captial和profit对存在里面，一个按capital从小到大，一个按profit从大到小，
    public static int findMaximizedCapital1(int k,int w, int[] Profits,int[] Capital){
        if(Capital==null||Capital.length==0)return 0;
        int len=Capital.length;
        PriorityQueue<int[]> cap=new PriorityQueue<>((a,b)->a[0]-b[0]);
        PriorityQueue<int[]> pro=new PriorityQueue<>((a,b)->b[1]-a[1]);
        for (int i = 0; i < len; i++) {
            cap.offer(new int[]{Capital[i],Profits[i]});
        }

        for (int i = 0; i < k; i++) {
            while(!cap.isEmpty()&&cap.peek()[0]<=w){
                pro.offer(cap.poll());
            }

            if(pro.isEmpty()) break;

            w+=pro.poll()[1];
        }
        return w;
    }
}
