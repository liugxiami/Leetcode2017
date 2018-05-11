package com.ccsi.leetcode3;

import java.util.*;

/**
 * Created by gxliu on 2018/5/9.
 * 下面程序不对
 */
public class LC399EvaluateDivisionUnionFind {
    public static void main(String[] args) {
        LC399EvaluateDivisionUnionFind resolution=new LC399EvaluateDivisionUnionFind();
        String[][] equations={{"a","b"},{"b","c"}};
        double[] values={2.0,3.0};
        String[][] queries={{"a","c"},{"b","c"},{"a","e"},{"a","a"},{"x","x"}};
        double[] res=resolution.calcEquation(equations,values,queries);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
    private class UFElement{
        String name;
        String parent;
        double value;

        UFElement(String name,String parent,double value){
            this.name=name;
            this.parent=parent;
            this.value=value;
        }
    }
    private Map<String,UFElement> map;
    public double[] calcEquation(String[][] equations,double[] values,String[][] queries){
        this.map=new HashMap<>();
        //no makeSet, union
        for (int i = 0; i < equations.length; i++) {
            String first=equations[i][0];
            String second=equations[i][1];
            union(first,second,values[i]);
        }

        double[] res=new double[queries.length];
        for (int i = 0; i < queries.length; i++) {  //？？？？？
            UFElement first=map.get(find(queries[i][0]));
            UFElement second=map.get(find(queries[i][1]));
            if(first==null||second==null||!first.parent.equals(second.parent))res[i]=-1.0;
            else res[i]=first.value/second.value;
        }

        return res;
    }
    private void union(String first,String second,double value){
        if(!map.containsKey(first)&&!map.containsKey(second)){
            map.put(first,new UFElement(first,second,value));
            map.put(second,new UFElement(second,second,1.0));
        }else if(!map.containsKey(first)){
            map.put(first,new UFElement(first,second,value));
        }else if(!map.containsKey(second)){
            map.put(second,new UFElement(second,first,1/value));
        }else{
            UFElement p1=map.get(find(first));
            UFElement p2=map.get(find(second));
            p1.parent=p2.parent;
            p1.value=value/p1.value*p2.value;
        }
    }
    private String find(String name){
        UFElement curr=map.get(name);
        while(true){
            String parent=curr.parent;
            if(parent.equals(curr.name))return parent;
            curr=map.get(parent);
        }
    }
}
