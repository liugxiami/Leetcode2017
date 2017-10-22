package com.ccsi.leetcode;

import java.util.LinkedList;
import java.util.Queue;

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

        Queue<TreeNode> pTree=new LinkedList<>();
        Queue<TreeNode> qTree=new LinkedList<>();
        pTree.offer(p);
        qTree.offer(q);
        while(!pTree.isEmpty()&&!qTree.isEmpty()){
            TreeNode pcurr=pTree.poll();
            TreeNode qcurr=qTree.poll();
            if(pcurr.val!=qcurr.val)return false;

            if(pcurr.left!=null&&qcurr.left!=null){
                pTree.offer(pcurr.left);
                qTree.offer(qcurr.left);
            }
            if(pcurr.right!=null&&qcurr.right!=null){
                pTree.offer(pcurr.right);
                qTree.offer(qcurr.right);
            }
        }

        if(!pTree.isEmpty()||!qTree.isEmpty())return false;

        return true;
    }

}
