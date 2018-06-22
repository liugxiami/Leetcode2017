package com.ccsi.leetcode4;

import java.util.*;

/**
 * Created by gxliu on 2018/6/18.
 * HashMap and PriorityQueue
 */
public class LC432AllOneDataStructure {
    private Map<String,Integer> map;
    private PriorityQueue<Map.Entry<String,Integer>> smallFirst;
    private PriorityQueue<Map.Entry<String,Integer>> bigFirst;
    public LC432AllOneDataStructure(){
        this.map=new HashMap<>();
        this.smallFirst=new PriorityQueue<>((o1,o2)->o1.getValue()-o2.getValue());
        this.bigFirst =new PriorityQueue<>((o1,o2)->o2.getValue()-o1.getValue());
    }
    public void inc(String key){
        if(key==null)return;
        if(!map.containsKey(key)){
            map.put(key,0);
        }
        map.put(key,map.get(key)+1);
    }
    public void dec(String key){
        if(key==null||!map.containsKey(key))return;
        if(map.get(key)==1)map.remove(key);
        else map.put(key,map.get(key)-1);
    }
    public String getMaxKey(){
        if(map.isEmpty())return "";
        for(Map.Entry ele:map.entrySet()){
            bigFirst.offer(ele);
        }
        String res=bigFirst.peek().getKey();
        bigFirst.clear();
        return res;
    }
    public String getMinKey(){
        if(map.isEmpty())return "";
        for(Map.Entry ele:map.entrySet()){
            smallFirst.offer(ele);
        }
        String res=smallFirst.peek().getKey();
        smallFirst.clear();
        return res;
    }

    public static void main(String[] args) {
        LC432AllOneDataStructure allOne=new LC432AllOneDataStructure();
        allOne.inc("one");
        allOne.inc("two");
        allOne.inc("one");
        System.out.println(allOne.getMaxKey());
        System.out.println(allOne.getMinKey());
        allOne.dec("one");
        allOne.dec("one");
        allOne.dec("two");
        System.out.println(allOne.getMaxKey());
        System.out.println(allOne.getMinKey());
    }
}
