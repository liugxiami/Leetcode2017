package com.ccsi.leetcode2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gxliu on 2017/12/23.
 */
public class LC236LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(5);
        root.left.left=new TreeNode(6);
        root.left.right=new TreeNode(2);
        root.left.right.left=new TreeNode(7);
        root.left.right.right=new TreeNode(4);
        root.right=new TreeNode(1);
        root.right.left=new TreeNode(0);
        root.right.right=new TreeNode(8);

        TreeNode res=lowestCommonAncestor1(root,new TreeNode(5),new TreeNode(4));
        System.out.println(res.val);
    }
    //method1 post-order
    public static TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        if(root==null||root.val==p.val||root.val==q.val)return root;

        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);

        if(left!=null&&right!=null)return root;
        else return left==null?right:left;
    }
    //method2 BT
    public static TreeNode lowestCommonAncestor1(TreeNode root,TreeNode p,TreeNode q){
        if(root==null||p==root||q==root)return root;

        List<List<TreeNode>> listP=new ArrayList<>();
        List<List<TreeNode>> listQ=new ArrayList<>();

        getPath(listP,new ArrayList<TreeNode>(),root,p);
        getPath(listQ,new ArrayList<TreeNode>(),root,q);

        TreeNode res=null;
        for (int i = 0; i < listP.get(0).size() && i < listQ.get(0).size(); i++) {
            if(listP.get(0).get(i)==listQ.get(0).get(i)){
                res=listP.get(0).get(i);
            }else break;
        }
        return res;
    }
    private static void getPath(List<List<TreeNode>> list,List<TreeNode> path,TreeNode root,TreeNode target){
        path.add(root);

        if(root.val==target.val){
            list.add(new ArrayList<>(path));
        }else{
            if(root.left!=null)getPath(list,path,root.left,target);
            if(root.right!=null)getPath(list,path,root.right,target);
        }

        path.remove(path.size()-1);
    }
}
