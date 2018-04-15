package com.ccsi.leetcode3;

import java.util.*;

/**
 * Created by gxliu on 2018/4/13.
 */
public class LC380InsertDeleteGeRandom {
    private List<Integer> list;
    private Map<Integer,Integer> map;

    public LC380InsertDeleteGeRandom(){
        this.list=new LinkedList<>();
        this.map=new HashMap<>();
    }

    public boolean insert(int val){
        if(map.containsKey(val))return false;
        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }

    public boolean remove(int val){
        if(!map.containsKey(val))return false;
        int i=map.get(val);
        int last=list.get(list.size()-1);
        if(last!=val){
            list.set(i,last);
            list.remove(list.size()-1);
            map.remove(val);
            map.put(last,i);
        }else{
            list.remove(list.size()-1);
            map.remove(val);
        }

        return true;
    }

    public int getRandom(){
        if(list.size()==0)return -1;
        if(list.size()==1)return list.get(0);
        int ran=new Random().nextInt(list.size());
        return list.get(ran);
    }

    public static void main(String[] args) {
        LC380InsertDeleteGeRandom randomSet=new LC380InsertDeleteGeRandom();
        randomSet.insert(1);
        randomSet.insert(3);
        randomSet.insert(4);
        System.out.println(randomSet.remove(2));
        randomSet.insert(2);
        System.out.println(randomSet.getRandom());
        randomSet.remove(1);
        System.out.println(randomSet.insert(2));
        System.out.println(randomSet.getRandom());

    }
}
