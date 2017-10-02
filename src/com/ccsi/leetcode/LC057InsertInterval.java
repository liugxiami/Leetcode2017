package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/9/29.
 */
public class LC057InsertInterval {
    public static void main(String[] args) {
        Interval i1=new Interval(1,2);
        Interval i2=new Interval(3,5);
        Interval i3=new Interval(6,7);
        Interval i4=new Interval(8,10);
        Interval i5=new Interval(12,16);
        List<Interval> intervals=new ArrayList<>();
        intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        intervals.add(i4);
        intervals.add(i5);

        Interval newInterval=new Interval(-2,0);
        List<Interval> res=insert1(intervals,newInterval);
        res.forEach(x->{
            System.out.print(x.start+" "+x.end);
            System.out.println();
        });
    }

    //method1,用的方法同前一题。
    public static List<Interval> insert(List<Interval> intervals,Interval newInterval){
        List<Interval> result=new ArrayList<>();
        if(intervals==null||intervals.size()==0){
            result.add(newInterval);
            return result;
        }

        intervals.add(newInterval);

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });

        Interval last=intervals.get(0);
        for (int i = 0; i < intervals.size(); i++) {
            Interval curr=intervals.get(i);
            if(last.end>curr.start){
                last.end=(last.end>curr.end)?last.end:curr.end;
            }else{
                result.add(last);
                last=curr;
            }
        }
        result.add(last);
        return result;
    }

    //method2，因为list里的元素已经是排好序的，那么只要比较newInterval与list里面的元素就好了，三种情况
    //1.newInterval假如在中间，那么比较new.start>i.end，如果是i.end小，直接加i进result
    //2.如果有重叠，不断跟新new的start和end，start是最小的，end是最大的
    //3.new.end小于i.start，将i加进result就行了。
    public static List<Interval> insert1(List<Interval> intervals,Interval newInterval){
        List<Interval> result=new ArrayList<>();
        if(intervals==null||intervals.isEmpty()){
            result.add(newInterval);
            return result;
        }

        int i=0;
        while(i<intervals.size()&&intervals.get(i).end<newInterval.start) result.add(intervals.get(i++));
        while(i<intervals.size()&&intervals.get(i).start<=newInterval.end){
            newInterval.start=Math.min(intervals.get(i).start,newInterval.start);
            newInterval.end=Math.max(intervals.get(i).end,newInterval.end);
            i++;
        }
        result.add(newInterval);
        while(i<intervals.size()&&intervals.get(i).start>newInterval.end)result.add(intervals.get(i++));
        return result;
    }
}
