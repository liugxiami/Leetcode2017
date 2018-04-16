package com.ccsi.leetcode3;

import java.util.*;

/**
 * Created by gxliu on 2018/4/15.
 */
public class LC381InsertDeleteGeRandomDuplicateAllowed {
    private List<Integer> list; // 用来存储元素
    private Map<Integer,List<Integer>> map; //key---元素，value---indexes
    public LC381InsertDeleteGeRandomDuplicateAllowed(){
        this.list=new LinkedList<>();
        this.map=new HashMap<>();
    }
    public boolean insert(int val){
        boolean canInsert=true;
        List<Integer> temp;
        if(!map.containsKey(val)){
            temp=new LinkedList<>();
        }else{
            canInsert=false;
            temp=map.get(val);
        }

        temp.add(list.size());
        map.put(val,temp);

        list.add(val);
        return canInsert;
    }
    public boolean remove(int val){
        if(!map.containsKey(val))return false;
        List<Integer> temp=map.get(val);
        int goingToBeDelete=temp.get(temp.size()-1);
        temp.remove(temp.size()-1);
        if(temp.isEmpty())map.remove(val);

        if(goingToBeDelete!=list.size()-1){
            int last=list.get(list.size()-1);
            List<Integer> in=map.get(last);
            in.set(in.size()-1,goingToBeDelete);
            Collections.sort(in);
            list.set(goingToBeDelete,last);
        }

        list.remove(list.size()-1);
        return true;
    }
    public int getRandom(){
        if(list.size()==0)return -1;
        if(list.size()==1)return list.get(0);

        int ran=new Random().nextInt(list.size());
        return list.get(ran);
    }
    public static void main(String[] args) {
        LC381InsertDeleteGeRandomDuplicateAllowed randomSet=new LC381InsertDeleteGeRandomDuplicateAllowed();
        randomSet.insert(9);
        randomSet.insert(9);
        randomSet.insert(1);
        randomSet.insert(1);
        randomSet.insert(2);
        randomSet.insert(1);
        randomSet.remove(2);
        randomSet.remove(1);
        randomSet.remove(1);
        randomSet.insert(9);
        randomSet.remove(1);

    }
}
