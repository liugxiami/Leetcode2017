package com.ccsi.leetcode5;

import java.util.ArrayList;
import java.util.List;

public class LC590NaryTreePostorderTraversal {
    public static void main(String[] args) {
        NaryTreeNode root=new NaryTreeNode();
        root.val=1;
        root.children=new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            root.children.add(new NaryTreeNode());
        }
        root.children.get(0).val=3;
        root.children.get(0).children=new ArrayList<>();
        root.children.get(1).val=2;
        root.children.get(2).val=4;
        root.children.get(0).children.add(new NaryTreeNode());
        root.children.get(0).children.add(new NaryTreeNode());
        root.children.get(0).children.get(0).val=5;
        root.children.get(0).children.get(1).val=6;

        List<Integer> res=postorder(root);
        for (int i:res) {
            System.out.println(i);
        }
    }
    private static List<Integer> result=new ArrayList<>();
    public static List<Integer> postorder(NaryTreeNode root){
        if(root==null)return result;
        DFS(root);
        return result;
    }
    private static void DFS(NaryTreeNode root){
        if(root==null)return;
        for(NaryTreeNode child:root.children){
            DFS(child);
        }
        result.add(root.val);
    }
}
