package com.ccsi.leetcode2;

import java.util.*;

/**
 * Created by gxliu on 2018/1/8.
 */
public class LC297SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        TreeNode root=BuildATree.buildABST();
        LC297SerializeAndDeserializeBinaryTree code=new LC297SerializeAndDeserializeBinaryTree();
        String str=code.serializeDFS(root);
        System.out.println(str);

        TreeNode newTree=code.deserialzieDFS(str);

    }
    private final String delimiter=",";
    private final String nullNode="#";
    //method 1 BSF
    public String Serialize(TreeNode root){
        if(root==null)return "";
        StringBuilder sb=new StringBuilder();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        sb.append(root.val).append(delimiter);

        while(!queue.isEmpty()){
            TreeNode curr=queue.poll();
            if(curr.left!=null){
                queue.offer(curr.left);
                sb.append(curr.left.val).append(delimiter);
            }else sb.append(Integer.MAX_VALUE).append(delimiter);

            if(curr.right!=null){
                queue.offer(curr.right);
                sb.append(curr.right.val).append(delimiter);
            }else sb.append(Integer.MAX_VALUE).append(delimiter);
        }

        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    public TreeNode deserialize(String data){
        if(data==null||data.length()==0)return null;
        String[] strs=data.split(delimiter);
        TreeNode root=new TreeNode(Integer.parseInt(strs[0]));
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int index=1;
        while(index<strs.length){
            TreeNode curr=queue.poll();
            int Lnum=Integer.parseInt(strs[index]);
            if(Lnum!=Integer.MAX_VALUE){
                curr.left=new TreeNode(Lnum);
                queue.offer(curr.left);
            }else{
                curr.left=null;
            }
            index++;

            int Rnum=Integer.parseInt(strs[index]);
            if(Rnum!=Integer.MAX_VALUE){
                curr.right=new TreeNode(Rnum);
                queue.offer(curr.right);
            }else{
                curr.right=null;
            }
            index++;
        }
        return root;
    }
    //method2 pre-order DFS


    public String serializeDFS(TreeNode root){
        StringBuilder sb=new StringBuilder();
        preOrderDFS(root,sb);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    private void preOrderDFS(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append(nullNode).append(delimiter);
            return;
        }

        sb.append(root.val).append(delimiter);
        preOrderDFS(root.left,sb);
        preOrderDFS(root.right,sb);
    }
    public TreeNode deserialzieDFS(String data){
        if(data==null)return null;
        Queue<String> queue=new LinkedList<>();
        //将一个集合加入到另外一种集合（如：queue）中的方法
        Collections.addAll(queue,data.split(delimiter));

        return preOrderDeserialize(queue);//利用一个queue，每次调用吐出一个。
    }
    private TreeNode preOrderDeserialize(Queue<String> queue){
        if(queue.isEmpty()){
            return null;
        }
        String curr=queue.poll();
        TreeNode root=null;
        if (!curr.equals(nullNode)){
            root=new TreeNode(Integer.valueOf(curr));
            root.left=preOrderDeserialize(queue);
            root.right=preOrderDeserialize(queue);
        }//否则就是nullNode，这时就什么也不做（没有左右子树），直接返回root，也就是null值。
        return root;
    }
}
