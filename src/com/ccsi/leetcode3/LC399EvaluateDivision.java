package com.ccsi.leetcode3;

import java.util.*;
/**
 * Created by gxliu on 2018/5/8.
 */
public class LC399EvaluateDivision {
    //method1 graph-DFS
    private class Node{
        String key;
        Double value;

        public Node(String key,Double value) {
            this.key =key;
            this.value = value;
        }
    }
    private Map<String,List<Node>> map;
    public double[] calcEquation(String[][] equations,double[] values,String[][] queries){
        map=new HashMap<>();
        int len=equations.length;
        for (int i = 0; i < len; i++) {
            String first=equations[i][0];
            String second=equations[i][1];
            if(!map.containsKey(first)){
                map.put(first,new ArrayList<>());
            }
            if(!map.containsKey(second)){
                map.put(second,new ArrayList<>());
            }

            map.get(first).add(new Node(second,values[i]));
            map.get(second).add(new Node(first,1/values[i]));
        }

        int size=queries.length;
        double[] result=new double[size];
        for (int i = 0; i < size; i++) {
            String first=queries[i][0];
            String second=queries[i][1];
            double res= DFS(first,second,1,new HashSet<>());
            result[i]=res;
        }
        return result;
    }
    private double DFS(String first, String second, double res, Set<String> visited){
        if(!map.containsKey(first)||!map.containsKey(second))return -1;
        if(first.equals(second))return res;
        else{
            visited.add(first);
            List<Node> children=map.get(first);
            Double result=-1.0; //小技巧
            for(Node child:children){
                if(!visited.contains(child.key)){
                    result=DFS(child.key,second,res*child.value,visited);
                    if(result>0)break;
                }
            }
            return result;
        }

    }

    public static void main(String[] args) {
        String[][] equations={{"a","b"},{"b","c"}};
        double[] values={2.0,3.0};
        String[][] queries={{"a","c"},{"b","c"},{"a","e"},{"a","a"},{"x","x"}};
        LC399EvaluateDivision resultion=new LC399EvaluateDivision();
        double[] result=resultion.calcEquation(equations,values,queries);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
