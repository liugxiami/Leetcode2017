package com.ccsi.leetcode4;

import java.util.*;

public class LC452MinimunNumberOfArrowsToBurstBalloons {
    public static void main(String[] args) {
        int[][] points={{10,16},{2,8},{1,6},{7,12},{17,20}};
        System.out.println(findMinArrowShots1(points));
    }
    //用一个priorityqueue来做，greedy，其实就是对气球进行排序，按start来排序，箭头位置最开始设定在第一气球
    //的end，然后迭代气球，如果下一个气球的start小于箭头位置，更新箭头位置为较小的当前箭头位置还是当前气球的end；
    //如果气球气球的start大于箭头位置了，那么需要新箭头了，同时更新新的箭头位置为当前气球的end
    public static int findMinArrowShots(int[][] points){
        if(points==null||points.length==0||points[0].length==0)return 0;
        int len=points.length;
        int shots=1;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        for (int i = 0; i < len; i++) {
            pq.offer(points[i]);
        }

        int[] firstBalloon=pq.poll();
        //int start=firstBalloon[0];
        int end=firstBalloon[1];

        while(!pq.isEmpty()){
            int[] nextBalloon=pq.poll();
            if(nextBalloon[0]<=end)end=nextBalloon[1]>end?end:nextBalloon[1];
            else{
                shots++;
                //start=nextBalloon[0];
                end=nextBalloon[1];
            }
        }
        return shots;
    }

    public static int findMinArrowShots1(int[][] points){
        if(points==null||points.length==0||points[0].length==0)return 0;
        Arrays.sort(points,(a,b)->a[0]-b[0]);
        int arrowPosition=points[0][1];
        int shots=1;
        for (int i = 1; i < points.length; i++) {
            if(points[i][0]<=arrowPosition)arrowPosition=Math.min(arrowPosition,points[i][1]);
            else{
                shots++;
                arrowPosition=points[i][1];
            }
        }
        return shots;
    }
    //先对数组进行排序，按气球的end进行排序，然后对每个气球进行迭代，箭头的位置为前面气球的end，如果下一个气球的start小于箭头位置，
    //那么说明可以被同一个箭头射穿，直接看下一个气球；如果下一个气球的start大于箭头位置了，那么需要一个新的箭头，箭头的位置更新为这个
    //气球的end，直到结束。这个解法的关键是箭头位置的确定。
    public static int findMinArrowShots2(int[][] points){
        if(points==null||points.length==0||points[0].length==0)return 0;
        Arrays.sort(points,(a,b)->a[1]-b[1]);
        int arrowPosition=points[0][1];
        int shots=1;
        for (int i = 1; i < points.length; i++) {
            if(points[i][0]<=arrowPosition)continue;
            shots++;
            arrowPosition=points[i][1];
        }
        return shots;
    }
}
