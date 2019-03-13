package com.ccsi.leetcode5;

import java.util.*;

public class LC599MinimumIndexSumOfTwoLists {
    public static void main(String[] args) {
        String[] list1={"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2={"KFC", "Shogun", "Burger King"};
        String[] result=findRestaurant(list1,list2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
    public static String[] findRestaurant(String[] list1,String[] list2){
        if(list1==null||list1.length==0||list2==null||list2.length==0)return null;
        if(list1.length>list2.length)return findRestaurant(list2,list1);//smaller list into map.
        List<String> result=new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            if(!map.containsKey(list1[i]))map.put(list1[i],i);
        }
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if(map.containsKey(list2[i])){
                int temp=map.get(list2[i])+i;
                if(min>temp){
                    min=temp;
                    result.clear();
                    result.add(list2[i]);
                }else if(min==temp){
                    result.add(list2[i]);
                }

            }
        }
        String[] res=new String[result.size()];
        result.toArray(res);
        return res;
    }
}
