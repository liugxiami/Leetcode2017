package com.ccsi.leetcode4;

import java.util.*;

public class LC497RandomPointInNonoverlappingRectangles {
    /*
    既然看到不重叠了，而且明显同一长方形内部的整数点被选择的概率相同，不同长方形内部的点被选择的概率等于该长方形的面积。
    那么我们肯定想到的是首先按照面积随机选择一个长方形，然后再在长方形中随机选择一个整数点就ok了。
    但要注意，其实这里不是直接用面积，而是这个长方形中有多少个整数点对。比如测试中[1,0,3,0],面积为0，但其实有3个点对。
    因此，其计算面积时稍有改动。
     */
    public static void main(String[] args) {
        int[][] rects={{-2,-2,-1,-1},{1,0,3,0}};
        for (int i = 0; i < 10; i++) {
            LC497RandomPointInNonoverlappingRectangles ran=new LC497RandomPointInNonoverlappingRectangles(rects);
            int[] result=ran.pick();
            System.out.printf("points: %d and %d",result[0],result[1]);
            System.out.println();
        }
    }
    private int[][] rects;
    private Random random;
    private int length;
    private TreeMap<Integer,Integer> treeMap;
    public LC497RandomPointInNonoverlappingRectangles(int[][] rects){
        this.rects=rects;
        random=new Random();
        treeMap=new TreeMap<>();
        length=0;
        for (int i = 0; i < rects.length; i++) {
            treeMap.put(length,i);
            int[] rect=rects[i];
            length+=(rect[2]-rect[0]+1)*(rect[3]-rect[1]+1);
        }
    }
    public int[] pick(){
        int[] result=new int[2];
        int ran=random.nextInt(length);
        int key=treeMap.floorKey(ran);
        int rect=treeMap.get(key);
        int left=rects[rect][0],bottom=rects[rect][1];
        int right=rects[rect][2],top=rects[rect][3];

        result[0]=left+(ran-key)%(right-left+1);
        result[1]=bottom+(ran-key)/(right-left+1);
        return result;
    }
}
