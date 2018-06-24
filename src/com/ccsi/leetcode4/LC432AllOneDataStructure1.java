package com.ccsi.leetcode4;

import java.util.*;

/**
 * Created by gxliu on 2018/6/21.
 */
public class LC432AllOneDataStructure1 {
    private Map<String,Integer> map;
    private TreeMap<Integer,Set<String>> treeMap;
    LC432AllOneDataStructure1(){
        this.map=new HashMap<>();
        this.treeMap=new TreeMap<>();
    }
    void inc(String key){
        if(key==null)return;
        if(!map.containsKey(key)){
            map.put(key,1);
            if(!treeMap.containsKey(1)){
                treeMap.put(1,new HashSet<>());
            }
            treeMap.get(1).add(key);
        }else{
            int counts=map.get(key);
            map.put(key,counts+1);
            treeMap.get(counts).remove(key);
            if(treeMap.get(counts).isEmpty())treeMap.remove(counts);
            if(!treeMap.containsKey(counts+1)){
                treeMap.put(counts+1,new HashSet<>());
            }
            treeMap.get(counts+1).add(key);
        }
    }
    void dec(String key){
        if(key==null||!map.containsKey(key))return;
        if(map.get(key)==1){
            map.remove(key);
            treeMap.get(1).remove(key);
            if(treeMap.get(1).isEmpty())treeMap.remove(1);
        }else{
            int count=map.get(key);
            map.put(key,count-1);
            treeMap.get(count).remove(key);
            if(treeMap.get(count).isEmpty())treeMap.remove(count);
            if(!treeMap.containsKey(count-1))treeMap.put(count-1,new HashSet<>());
            treeMap.get(count-1).add(key);
        }
    }
    String getMaxKey(){
        return treeMap.isEmpty()?"":treeMap.get(treeMap.lastKey()).iterator().next();
    }
    String getMinKey(){
        return treeMap.isEmpty()?"":treeMap.get(treeMap.firstKey()).iterator().next();
    }
    public static void main(String[] args) {
        LC432AllOneDataStructure1 allOne=new LC432AllOneDataStructure1();
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
