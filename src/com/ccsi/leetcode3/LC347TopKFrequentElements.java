package com.ccsi.leetcode3;

import java.util.*;

/**
 * Created by gxliu on 2018/3/18.
 */
public class LC347TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums={1};
        List<Integer> result=topKFrequent1(nums,1);
        result.forEach(a-> System.out.println(a));
    }
    //method1 hashMap+prioryQueue
    public static List<Integer> topKFrequent(int[] nums,int k){
        List<Integer> result=new ArrayList<>();
        if(nums==null||nums.length==0||k<=0)return result;
        int len=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        //lambda expression
        PriorityQueue<Map.Entry<Integer,Integer>> priorityQueue=new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));

        for(Integer n:nums){
            if(!map.containsKey(n))map.put(n,0);
            map.put(n,map.get(n)+1);
        }

        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            priorityQueue.offer(e);
        }

        int count=k;
        while(count-->0){
            result.add(priorityQueue.poll().getKey());
        }

        return result;
    }
    //method2 hashMap+bucket sort
    public static List<Integer> topKFrequent1(int[] nums,int k){
        List<Integer> result=new ArrayList<>();
        if(nums==null||nums.length==0||k<=0)return result;
        int len=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        List<Integer>[] buckets=new ArrayList[len+1];
        //需要对这个桶先进行初始化。
        for (int i = 0; i <= len; i++) {
            buckets[i]=new ArrayList<>();
        }
        //进map
        for(Integer n:nums){
            if(!map.containsKey(n)){
                map.put(n,0);
            }
            map.put(n,map.get(n)+1);
        }
        //进桶 桶的index就是frequent，内容是原来的数组中的数字
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            buckets[entry.getValue()].add(entry.getKey());
        }
        //从桶中倒出前k个，注意其中index就是出现频率
        for (int i = len; i >=0&&result.size()<k; i--) {
            if(!buckets[i].isEmpty())result.addAll(buckets[i]);
        }
        return result;
    }
}
