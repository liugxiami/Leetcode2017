package com.ccsi.leetcode3;

import java.util.*;

/**
 * Created by gxliu on 2018/3/22.
 */
public class LC354RussianDollEnvelopes {
    public static void main(String[] args) {
        int[][] envelopes={{5,4},{6,4},{6,7},{2,3}};
        System.out.println(maxEnvelopes1(envelopes));
    }
    //这是一开始的解法，想法过于简单了，这种贪心的算法是不对的。
    public static int maxEnvelopes(int[][] envelopes){
        if(envelopes==null||envelopes.length==0||envelopes[0].length==0)return 0;
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>((a,b)->{
            if(a[0]==b[0])return a[1]-b[1];
            else return a[0]-b[0];});

        int len=envelopes.length;
        for (int i = 0; i < len; i++) {
            pq.offer(envelopes[i]);
        }

        int counter=1;
        int[] curr=pq.poll();
        while(!pq.isEmpty()){
            int[] temp=pq.poll();
            if(curr[0]<temp[0]&&curr[1]<temp[1]){
                counter++;
                curr=temp;
            }
        }
        return counter;
    }
    //DP
    public static int maxEnvelopes1(int[][] envelopes){
        if(envelopes==null||envelopes.length==0||envelopes[0]==null||envelopes[0].length==0)return 0;
        //1.对数组排序，先按width从小到大排，如果相同，那么按hight从大到小排（这样可以避免相同width的被重复计算）。
        Arrays.sort(envelopes,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0])return o2[1]-o1[1];
                else return o1[0]-o2[0];
            }
        });
        //2.利用二分查找来维持一个递增的最大长度数组，根据height。
        int[] dp=new int[envelopes.length];
        int len=0;
        for (int[] envelope:envelopes) {
            int left=0;
            int right=len-1;
            while(left<=right){
                int mi=left+(right-left)/2;
                if(dp[mi]<envelope[1])left=mi+1;
                else right=mi-1;
            }
            dp[left]=envelope[1];
            if(left==len)len++;
        }
        return len;
    }
}
