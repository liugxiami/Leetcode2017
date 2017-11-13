package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/11/12.
 */
public class LC133CloneGraph {
    public static void main(String[] args) {
        UndirectedGraphNode root=buildTree();
        UndirectedGraphNode res=cloneGraphBFS(root);
    }
    //method1：借助两个辅助函数，都原图进行序列化成string，然后在将这个string反序列化成图。
    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
        if(node==null)return null;
        String serializedString=serializeBFS(node); //对图进行序列化
        UndirectedGraphNode result=deserialized(serializedString); //再对这个string进行反序列化。
        return result;
    }
    //BFS序列化
    private static String serializeBFS(UndirectedGraphNode curr){
        StringBuilder result=new StringBuilder();
        Set<UndirectedGraphNode> visited=new HashSet<>();
        Queue<UndirectedGraphNode> queue=new LinkedList<>();
        queue.offer(curr);
        while(!queue.isEmpty()){
           Queue<UndirectedGraphNode> next=new LinkedList<>();
           while(!queue.isEmpty()){
               UndirectedGraphNode temp=queue.poll();
               visited.add(temp);
               StringBuilder str=new StringBuilder();
               str.append(temp.label+",");
               List<UndirectedGraphNode> neighbors=temp.neighbors;
               for(UndirectedGraphNode neighbor:neighbors){
                   str.append(neighbor.label+",");
                   if(!visited.contains(neighbor)){
                       next.offer(neighbor);
                       visited.add(neighbor);
                   }
               }
               str.deleteCharAt(str.length()-1);
               result.append(str.toString()+"#");
           }
           queue=next;
        }
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }
    //BFS反序列化
    private static UndirectedGraphNode deserialized(String str){
        if(str==null||str.length()==0)return null;
        Queue<String> queue=new LinkedList<>();
        Map<Integer,UndirectedGraphNode> visited=new HashMap<>();
        UndirectedGraphNode root=new UndirectedGraphNode(-1);
        UndirectedGraphNode curr;
        StringBuilder sb=new StringBuilder();
        int index=0;
        while(index<=str.length()){
            if(index<str.length()&&str.charAt(index)!='#'){
                if(str.charAt(index)!=','){
                    sb.append(str.charAt(index));
                }else{
                    queue.offer(sb.toString());
                    sb.setLength(0);
                }
            }

            if(index==str.length()||str.charAt(index)=='#'){
                if(sb!=null){
                    queue.offer(sb.toString());
                    sb.setLength(0);
                }

                Integer temp=Integer.valueOf(queue.poll());

                if(visited.isEmpty()){
                    root=new UndirectedGraphNode(temp);
                    curr=root;
                    visited.put(temp,root);
                }else if(!visited.containsKey(temp)){
                    curr=new UndirectedGraphNode(temp);
                    visited.put(temp,curr);
                }else{
                    curr=visited.get(temp);
                }

                while(!queue.isEmpty()){
                    Integer neighbor=Integer.valueOf(queue.poll());
                    if(!visited.containsKey(neighbor)){
                        UndirectedGraphNode nei=new UndirectedGraphNode(neighbor);
                        curr.neighbors.add(nei);
                        visited.put(neighbor,nei);
                    }else{
                        curr.neighbors.add(visited.get(neighbor));
                    }
                }
            }
            index++;
        }

        return root;
    }

    //method2：直接DFS
    private static Map<Integer,UndirectedGraphNode> visited=new HashMap<>();
    public static UndirectedGraphNode cloneGraphDFS(UndirectedGraphNode node){
        if(node==null)return node;
        if(visited.containsKey(node.label))return visited.get(node.label);

        UndirectedGraphNode newNode=new UndirectedGraphNode(node.label);
        visited.put(node.label,newNode);
        for (UndirectedGraphNode neighbor:node.neighbors) {
            newNode.neighbors.add(cloneGraphDFS(neighbor));
        }
        return newNode;
    }

    //method3.BFS
    public static UndirectedGraphNode cloneGraphBFS(UndirectedGraphNode node){
        if(node==null)return node;
        Map<Integer,UndirectedGraphNode> map=new HashMap<>();
        Queue<UndirectedGraphNode> queue=new LinkedList<>();
        Queue<UndirectedGraphNode> resultQueue=new LinkedList<>();
        UndirectedGraphNode result=new UndirectedGraphNode(node.label);
        queue.offer(node);
        resultQueue.offer(result);

        map.put(node.label,node);
        while(!queue.isEmpty()){
            UndirectedGraphNode temp=queue.poll();
            UndirectedGraphNode resultTemp=resultQueue.poll();

            List<UndirectedGraphNode> neighbors=temp.neighbors;
            for(UndirectedGraphNode neighbor:neighbors){
                if(!visited.containsKey(neighbor.label)){
                    UndirectedGraphNode nei=new UndirectedGraphNode(neighbor.label);
                    visited.put(neighbor.label,nei);

                    queue.offer(neighbor);
                    resultQueue.offer(nei);

                    resultTemp.neighbors.add(nei);
                }else{
                    resultTemp.neighbors.add(visited.get(neighbor.label));
                }
            }
        }
        return result;
    }
    private  static UndirectedGraphNode buildTree(){
        UndirectedGraphNode r0=new UndirectedGraphNode(0);
        UndirectedGraphNode r1=new UndirectedGraphNode(1);
        UndirectedGraphNode r2=new UndirectedGraphNode(2);

        r0.neighbors.add(r1);
        r0.neighbors.add(r2);

        r1.neighbors.add(r2);

        r2.neighbors.add(r2);

        return r0;
    }
}
