package com.ccsi.leetcode4;

import java.util.Arrays;

/**
 * Created by gxliu on 2018/6/24.
 */
public class LC435NonOverlappingIntervals {
    public static void main(String[] args) {
        Interval[] intervals=new Interval[4];
        intervals[0]=new Interval(1,2);
        intervals[1]=new Interval(2,3);
        intervals[2]=new Interval(3,4);
        intervals[3]=new Interval(1,3);
        System.out.println(eraseOverLapIntervals(intervals));
    }
    //greedy
    public  static int eraseOverLapIntervals(Interval[] intervals){
        if(intervals==null||intervals.length==0)return 0;
        Arrays.sort(intervals,(a,b)->(a.start==b.start?a.end-b.end:a.start-b.start));
        int pre=0;
        int count=0;
        for (int curr = 1; curr < intervals.length; curr++) {
            if(intervals[curr].start<intervals[pre].end){ //如果有overlap
                pre=(intervals[curr].end<intervals[pre].end)?curr:pre; //取覆盖较小的那个为pre
                count++;
            }else pre=curr; //没有overlap的话，就设当前这个为pre
        }
        return count;
    }
}
