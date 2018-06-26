package com.ccsi.leetcode4;

import java.util.*;

/**
 * Created by gxliu on 2018/6/25.
 */
public class LC436FindRightInterval {
    public static void main(String[] args) {
        Interval[] intervals=new Interval[3];
        intervals[0]=new Interval(1,4);
        intervals[1]=new Interval(2,3);
        intervals[2]=new Interval(3,4);
        int[] res=findRightInterval(intervals);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }

    }
    public static int[] findRightInterval(Interval[] intervals){
        if(intervals==null||intervals.length==0)return null;
        int len=intervals.length;
        int[] result=new int[len];

        TreeMap<Integer,Integer> map=new TreeMap<>();//key--start;value--index
        for (int i = 0; i < len; i++) {
            map.put(intervals[i].start,i);
        }

        for (int i = 0; i < len; i++) {
            Map.Entry<Integer,Integer> entry=map.ceilingEntry(intervals[i].end);
            result[i]=entry==null?-1:entry.getValue();
        }
        return result;
    }
}
