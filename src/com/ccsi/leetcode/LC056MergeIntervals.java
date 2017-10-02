package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/9/29.
 */
public class LC056MergeIntervals {
    public static void main(String[] args) {
        Interval i1=new Interval(1,3);
        Interval i2=new Interval(2,6);
        Interval i3=new Interval(8,10);
        Interval i4=new Interval(15,18);
        Interval i5=new Interval(14,16);
        List<Interval> intervals=new ArrayList<>();
        intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        intervals.add(i4);
        intervals.add(i5);

        List<Interval> res=merge(intervals);
        res.forEach(x->{
            System.out.print(x.start+"and"+x.end);
            System.out.println();
        });
    }

    public static List<Interval> merge(List<Interval> intervals){
        if(intervals==null||intervals.size()<=1)return intervals;

        List<Interval> result=new ArrayList<>();

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });

        Interval last=intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval curr=intervals.get(i);
            if(last.end>=curr.start){
                last.end=last.end>curr.end?last.end:curr.end;
            }else{
                result.add(last);
                last=curr;
            }
        }

        result.add(last);

        return result;
    }
}