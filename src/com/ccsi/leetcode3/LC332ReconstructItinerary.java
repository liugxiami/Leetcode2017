package com.ccsi.leetcode3;

import java.util.*;

/**
 * Created by gxliu on 2018/3/6.
 */
public class LC332ReconstructItinerary {
    public static void main(String[] args) {
        String[][] tickets={{"JFK", "KUL"}, {"JFK", "NRT"}, {"NRT", "JFK"}};
        List<String> result=findItinerary(tickets);
        result.forEach(x-> System.out.println(x));
    }
    public static Map<String,PriorityQueue<String>> map=new HashMap<>();
    public static List<String> result=new ArrayList<>();

    public static List<String> findItinerary(String[][] tickets){
        if(tickets==null||tickets.length==0||tickets[0].length==0)return result;
        int len=tickets.length;

        for (int i = 0; i < len; i++) {
            String start=tickets[i][0];
            String des=tickets[i][1];
            if(!map.containsKey(start)){
                map.put(start,new PriorityQueue<>());
            }
            map.get(start).offer(des);
        }

        visit("JFK");
        return result;
    }
    //递归找路线
    private static void visit(String start){
        while(map.containsKey(start)&&!map.get(start).isEmpty()){
            visit(map.get(start).poll());
        }
        result.add(0,start);
    }
}
