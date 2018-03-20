package com.ccsi.leetcode3;

import java.util.*;

/**
 * Created by gxliu on 2018/3/19.
 */
public class LC352DataStreamAsDisjointIntervals {
    public static void main(String[] args) {
        LC352DataStreamAsDisjointIntervals intervals=new LC352DataStreamAsDisjointIntervals();
        intervals.addNum(1);
        intervals.addNum(3);
        intervals.addNum(7);
        intervals.addNum(2);
        intervals.addNum(6);
        List<Interval> result=intervals.getIntervals();
    }
    //TreeSet ceiling and floor or lower and higher
    private TreeSet<Interval> intervalSet;
    public LC352DataStreamAsDisjointIntervals() {
        intervalSet =new TreeSet<>((a,b)->(a.start-b.start));
    }
    public void addNum(int val){
        Interval curr=new Interval(val,val);
        Interval lower=intervalSet.lower(curr);
        if(lower!=null){
            if(lower.end>=curr.start){
                curr=lower;
                intervalSet.remove(lower);
            }
            else if(lower.end+1==curr.start){
                curr.start=lower.start;
                intervalSet.remove(lower);
            }
        }
        Interval higher=intervalSet.higher(curr);
        if(higher!=null){
            if(curr.end+1>=higher.start){
                curr.end=higher.end;
                intervalSet.remove(higher);
            }
        }
        intervalSet.add(curr);
    }
    public List<Interval> getIntervals(){
        List<Interval> result=new ArrayList<>();
        for(Interval interval:intervalSet){
            result.add(interval);
        }
        return result;
    }
}
