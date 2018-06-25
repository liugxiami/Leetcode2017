package com.ccsi.leetcode4;

import java.util.*;

/**
 * Created by gxliu on 2018/6/23.
 */
public class LC433MinimumGeneticMutation {
    public static void main(String[] args) {
        String start="AAAAACCC";
        String end="AACCCCCC";
        String[] bank={"AAAACCCC","AAACCCCC","AACCCCCC"};
        System.out.println(minMutation(start,end,bank));
    }
    public static int minMutation(String start,String end,String[] bank){
        if(bank==null||bank.length==0)return -1;
        if(start.length()!=end.length())return -1;
        //其实就是找最短路径，每次只能走一步
        Set<String> visited=new HashSet<>(); //可以加快一些，如果数据量大了之后
        Queue<String> queue=new LinkedList<>();
        queue.offer(start);
        int count=0;
        while(!queue.isEmpty()){
            Queue<String> next=new LinkedList<>();
            while (!queue.isEmpty()){
                String temp=queue.poll();
                visited.add(temp);
                if(temp.equals(end))return count;
                for(String str:bank){
                    if(!visited.contains(str)&&mutations(temp,str)==1){
                        next.offer(str);
                    }
                }
            }
            queue=next;
            count++;
        }
        return -1;
    }
    private static int mutations(String start,String end){
        int count=0;
        for (int i = 0; i < 8; i++) {
            if(start.charAt(i)!=end.charAt(i))count++;
        }
        return count;
    }
}
