package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/12/3.
 */
public class LC199BinaryTreeRightSideView {
    public static void main(String[] args) {
        TreeNode root=BuildTree.buildATree();
        List<Integer> res=rightSideViewDFS(root);
        res.forEach(x-> System.out.println(x));
    }
    //BFS 按层遍历
    public static List<Integer> rightSideView(TreeNode root){
        List<Integer> result=new ArrayList<>();
        if(root==null)return result;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Queue<TreeNode> next=new LinkedList<>();
            while(!queue.isEmpty()){
                TreeNode curr=queue.poll();

                if(queue.isEmpty()){
                    result.add(curr.val);
                }

                if(curr.left!=null)next.offer(curr.left);
                if(curr.right!=null)next.offer(curr.right);
            }
            queue=next;
        }
        return result;
    }
    //DFS 巧妙利用result的size与层数的关系，DFS先走右子树，如果进入新的一层，那么必然是第一个就是最右边的，怎么知道是否进入新的
    //一层，这里利用了result的size与传入参数level的关系决定，因为每进入新的 一层才加一个数，所以这个result的size就记录了层数
    //当传入参数level与它相同时，就说明进入新的一层了，那么就将当前这个节点的值记录下来。
    public static List<Integer> rightSideViewDFS(TreeNode root){
        List<Integer> result=new ArrayList<>();
        if(root==null)return result;
        DFS(root,result,0);
        return result;
    }
    private static void DFS(TreeNode curr,List<Integer> result,int level){
        if(curr==null)return;

        if(result.size()==level){
            result.add(curr.val);
        }

        DFS(curr.right,result,level+1);
        DFS(curr.left,result,level+1);
    }
}
