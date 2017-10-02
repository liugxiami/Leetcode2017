package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/10/1.
 */
public class LC060PermutationSequence {
    public static void main(String[] args) {
        System.out.println(getPermutation1(3,2));
    }
    //method 1: BT+DFS,太慢，过不了leetcode
    public static String getPermutation(int n,int k){
        if(n<1)return "";
        int total=1;
        for (int i = 1; i <=n; i++) {
            total*=i;
        }
        if(k>total)return "";

        helper(new StringBuilder(),0,n,k,new boolean[n+1]);
        return result;
    }

    private static int n =0;
    private static String result;
    private static void helper(StringBuilder stack,int index,int n,int k,boolean[] visited){
        if(stack.length()==n){
            LC060PermutationSequence.n++;
            if(LC060PermutationSequence.n ==k){
                result=stack.toString();
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            if(!visited[i]){
                stack.append(i);
                visited[i]=true;
                helper(stack,i,n,k,visited);
                visited[stack.charAt(stack.length()-1)-'0']=false;
                stack.deleteCharAt(stack.length()-1);
            }
        }
    }

    //method 2：利用一定的数学知识，1到n的数字组合有n！个，那么以1开头的有（n-1）！个，2开头的也是（n-1）！个...直到n。
    //也就是说，如果k/（n-1）！就是头一个数字，k%（n-1）！就是下一个数字的k'，这样一直循环到 n-（n-1）
    public static String getPermutation1(int n,int k){
        if(n<1)return "";
        List<Integer> nums=new LinkedList<>();
        int factorial=1;
        for (int i = 1; i <=n ; i++) {
            nums.add(i);
            factorial*=i;
        }

        StringBuilder str=new StringBuilder();

        k--;

        while(n>0){
            factorial/=n;
            int curr=k/factorial;
            str.append(nums.remove(curr));
            k%=factorial;
            n--;
        }

        return str.toString();

    }
}
