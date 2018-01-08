package com.ccsi.leetcode2;

import java.util.*;

/**
 * Created by gxliu on 2018/1/7.
 */
public class LC295FindMedianFromDataStream {
    PriorityQueue<Integer> firstHalfMax;
    PriorityQueue<Integer> secondHalfMin;
    public LC295FindMedianFromDataStream(){
        firstHalfMax=new PriorityQueue<>(1000, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        secondHalfMin=new PriorityQueue<>();
    }
    public void addNum(int num){
        firstHalfMax.offer(num);
        secondHalfMin.offer(firstHalfMax.poll());
        if(firstHalfMax.size()<secondHalfMin.size())firstHalfMax.offer(secondHalfMin.poll());
    }
    public double findMedian(){
        if(firstHalfMax.isEmpty())return Double.MAX_VALUE;
        if(secondHalfMin.isEmpty())return firstHalfMax.peek();
        if(firstHalfMax.size()==secondHalfMin.size()){
            return (firstHalfMax.peek()+secondHalfMin.peek())/2.0;
        }else return firstHalfMax.peek();
    }

    public static void main(String[] args) {
        LC295FindMedianFromDataStream medianFind=new LC295FindMedianFromDataStream();
        medianFind.addNum(1);
        medianFind.addNum(2);
        System.out.println(medianFind.findMedian());
        medianFind.addNum(3);
        System.out.println(medianFind.findMedian());
    }
}
