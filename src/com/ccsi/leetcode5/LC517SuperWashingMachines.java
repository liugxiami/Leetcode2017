package com.ccsi.leetcode5;

public class LC517SuperWashingMachines {
    public static void main(String[] args) {
        int[] machines={4,0,0,4};
        System.out.println(findMinMoves(machines));
    }
    public static int findMinMoves(int[] machines){
        if(machines==null||machines.length==0)return 0;
        int len=machines.length;
        int sum=0;
        for (int i = 0; i < len; i++) {
            sum+=machines[i];
        }
        if(sum%len!=0)return -1;
        int avg=sum/len;
        int cnt=0;
        int moves=0;
        for (int i = 0; i < len; i++) {
            cnt+=machines[i]-avg;
            moves=Math.max(moves,Math.max(Math.abs(cnt),machines[i]-avg));
        }
        return moves;
    }
}
