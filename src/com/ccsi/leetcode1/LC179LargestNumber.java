package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/12/1.
 */
public class LC179LargestNumber {
    //声明一个新的私有类，实现了接口Comparable，当然也可以在比较时用new Comparator。
    private class Num implements Comparable<Num>{
        String val;

        @Override
        public int compareTo(Num o) {
            String first=o.val+val; //比较的是字符串，反过来倒过去的两个数大小比较。
            String second=val+o.val;  //我们希望是从大到小排，所以是o在前，通常的排序是从小到大，那就字段在前。
            return first.compareTo(second);
        }
    }
    //method1
    public String largestNumber(int[] nums){
        if(nums==null||nums.length==0)return "";
        int len=nums.length;
        Num[] numbers=new Num[len];

        for (int i = 0; i < len; i++) {
            numbers[i]=new Num();
            numbers[i].val=String.valueOf(nums[i]);
        }
        Arrays.sort(numbers);  //排序，或者直接用一个priorityQueue.

        StringBuilder result=new StringBuilder("");
        for (int i = 0; i <len; i++) {
            if(numbers[i].val.equals("0")&&result.toString().equals(""))continue;
            result.append(numbers[i].val);
        }

        return result.toString().equals("")?"0":result.toString();

    }
    //method2 PriorityQueue
    public String largestNumber1(int[] nums){
        if(nums==null||nums.length==0)return "";
        int len=nums.length;
        PriorityQueue<Num> pq=new PriorityQueue<>();

        for (int i = 0; i < len; i++) {
            Num temp=new Num();
            temp.val=String.valueOf(nums[i]);
            pq.offer(temp);
        }

        StringBuilder result=new StringBuilder("");
        while(!pq.isEmpty()){
            Num curr=pq.poll();
            if(curr.val.equals("0")&&result.toString().equals("")) {
                continue;
            }
            result.append(curr.val);
        }

        return result.toString().equals("")?"0":result.toString();

    }

    public static void main(String[] args) {
        LC179LargestNumber large=new LC179LargestNumber();
        int[] nums={3, 30, 34, 5, 9,0};
        System.out.println(large.largestNumber1(nums));
    }
}
