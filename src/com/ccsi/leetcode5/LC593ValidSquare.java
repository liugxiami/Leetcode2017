package com.ccsi.leetcode5;

import java.util.*;

public class LC593ValidSquare {
    public static void main(String[] args) {
        System.out.println(validSquare(new int[]{0,0},new int[]{0,1},new int[]{1,1},new int[]{1,0}));
    }
    //trick：square的边是相等的，那么四个顶点之间的距离只有两种，一是边，另一是对角线。
    public static boolean validSquare(int[] p1,int[] p2,int[] p3,int[] p4){
        Set<Integer> set=new HashSet<>();
        set.add(distance(p1,p2));
        set.add(distance(p1,p3));
        set.add(distance(p1,p4));
        set.add(distance(p2,p3));
        set.add(distance(p2,p4));
        set.add(distance(p3,p4));
        return !set.contains(0)&&set.size()==2;
    }
    private static int distance(int[] a,int[] b){
        return (a[0]-b[0])*(a[0]-b[0])+(a[1]-b[1])*(a[1]-b[1]);
    }
}
