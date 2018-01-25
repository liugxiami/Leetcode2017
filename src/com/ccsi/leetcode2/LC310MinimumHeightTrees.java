package com.ccsi.leetcode2;

import java.util.*;

/**
 * Created by gxliu on 2018/1/24.
 */
public class LC310MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n,int[][] edges){
        if(n<=1)return Collections.singletonList(0);
        List<Set<Integer>> graph=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(i,new HashSet<>());
        }

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        List<Integer> leaves=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(graph.get(i).size()==1)leaves.add(i);
        }

        while(n>2){
            n-=leaves.size();
            List<Integer> newLeaves=new ArrayList<>();
            for(int i:leaves){
                for(int newLeaf:graph.get(i)){
                    graph.get(newLeaf).remove(i);
                    graph.get(i).remove(newLeaf);
                    if(graph.get(newLeaf).size()==1)newLeaves.add(newLeaf);
                }
            }
            leaves=newLeaves;
        }
        return leaves;
    }

}
