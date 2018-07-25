package com.ccsi.leetcode4;

import java.util.*;

/**
 * Created by gxliu on 2018/7/24.
 */
public class LC447NumberOfBoomerangs {
    public static void main(String[] args) {
        int[][] points={{1,0},{0,0},{2,0},{3,0}};
        System.out.println(numberOfBoomerangs(points));
    }
    public static int numberOfBoomerangs(int[][] points){
        if(points==null||points.length<3)return 0;
        int result=0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer,Integer> map=new HashMap<>(); //key--distance,value--count
            for (int j = 0; j < points.length; j++) {
                int deltaA=points[i][0]-points[j][0];
                int deltaB=points[i][1]-points[j][1];
                int distance=deltaA*deltaA+deltaB*deltaB;
                if(map.containsKey(distance))map.put(distance,map.get(distance)+1);
                else map.put(distance,1);
            }
            for(int value:map.values()){
                result+=(value-1)*(value);
            }
        }
        return result;
    }
}
