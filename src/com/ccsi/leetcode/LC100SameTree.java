package com.ccsi.leetcode;

import java.util.Stack;

/**
 * Created by gxliu on 2017/10/20.
 */
public class LC100SameTree {
    public static boolean isSameTree(TreeNode p,TreeNode q){
        if(p==null&&q==null)return true;
        if(p==null||q==null)return false;
        if(p.val!=q.val)return false;

        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }

    public static boolean isSameTree1(TreeNode p,TreeNode q){
        if(p==null&&q==null)return true;
        if(p==null||q==null)return false;
        if(p.val!=q.val)return false;

        Stack<TreeNode> pTree=new Stack<>();
        Stack<TreeNode> qTree=new Stack<>();
        pTree.push(p);
        qTree.push(q);
        while(!pTree.isEmpty()&&!qTree.isEmpty()){
            TreeNode pcurr=pTree.pop();
            TreeNode qcurr=qTree.pop();
            if(pcurr.val!=qcurr.val)return false;

            if(pcurr.left!=null&&qcurr.left!=null){
                pTree.push(pcurr.left);
                qTree.push(qcurr.left);
            }
            if(pcurr.right!=null&&qcurr.right!=null){
                pTree.push(pcurr.right);
                qTree.push(qcurr.right);
            }
        }

        if(!pTree.isEmpty()||!qTree.isEmpty())return false;

        return true;
    }
}
