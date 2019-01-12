package com.ccsi.leetcode5;

import java.util.ArrayList;

public class LC559MaximumDepthOfNaryTree {
    public static void main(String[] args) {
        NaryTreeNode root=new NaryTreeNode(1,new ArrayList<>());
        root.children.add(new NaryTreeNode(3,new ArrayList<>()));
        root.children.add(new NaryTreeNode(2,null));
        root.children.add(new NaryTreeNode(4,null));
        root.children.get(0).children.add(new NaryTreeNode(5,null));
        root.children.get(0).children.add(new NaryTreeNode(6,null));
        System.out.println(maxDepth(root));
    }
    public static int maxDepth(NaryTreeNode root){
        if(root==null)return 0;
        if(root.children==null||root.children.size()==0)return 1;
        int maxHeight=0;
        for(NaryTreeNode child:root.children){
            maxHeight=Math.max(maxHeight,maxDepth(child));
        }
        return maxHeight+1;
    }
}
