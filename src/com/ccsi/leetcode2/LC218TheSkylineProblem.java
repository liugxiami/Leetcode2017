package com.ccsi.leetcode2;

import java.util.*;

/**
 * Created by gxliu on 2017/12/16.
 */
public class LC218TheSkylineProblem {
    public static void main(String[] args) {
        int[][] building={{2, 9 ,10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        List<int[]> res=getSkyline(building);
        for (int i = 0; i < res.size(); i++) {
            int[] edge=res.get(i);
            System.out.print(edge[0]+" "+edge[1]);
            System.out.println();
        }
    }
    public static List<int[]> getSkyline(int[][] building){
        List<int[]> result=new ArrayList<>();
        if(building==null||building.length==0||building[0].length==0)return result;
        int len=building.length;

        List<int[]> edges=new ArrayList<>();
        for (int i = 0; i < len; i++) {
            edges.add(new int[]{building[i][0],-building[i][2]}); //左x和高度，这个高度前加一个‘-’表示左边
            edges.add(new int[]{building[i][1],building[i][2]});  //右x和高度
        }
        //对这些边进行排序，如果在x轴上不同位置，从小到大排序；如果是相同的x，那么那属于右x的排在片面（通过高度的正负数来判断）。
        Collections.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0])return o1[0]-o2[0];
                else return o1[1]-o2[1];
            }
        });

        PriorityQueue<Integer> pq=new PriorityQueue<>(edges.size(), new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        pq.offer(0);
        int pre=0;
        for (int i = 0; i < edges.size(); i++) {
            int[] edge=edges.get(i);
            if(edge[1]<0){
                pq.offer(-edge[1]);
            }else{
                pq.remove(edge[1]);
            }

            int height=pq.peek();
            if(pre!=height){
                result.add(new int[]{edge[0],height});
                pre=height;
            }
        }
        return result;
    }
}
