package com.ccsi.leetcode4;

import java.util.*;

/**
 * Created by gxliu on 2018/5/17.
 */
public class LC406QueueReconstructionByHeight {
    public static void main(String[] args) {
        int[][] people={{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] result=reconstructQueue(people);
        for (int i = 0; i < result.length; i++) {
            System.out.printf(result[i][0]+" "+result[i][1]);
            System.out.println();
        }
    }
    public static int[][] reconstructQueue(int[][] people){
        if(people==null||people.length==0)return people;
        int len=people.length;
        //先对数组进行排序，按升高从高到低，如果相同身高则按第二个数从小到到排。
        Arrays.sort(people,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                if(a[0]!=b[0])return b[0]-a[0];
                else return a[1]-b[1];
            }
        });
        //insert 从上面排好序的数组中，从前到后按其第二个数作为index插入到list中去，保证正在插入的这个数进入
        //正确的位置。
        List<int[]> list=new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int[] curr=people[i];
            list.add(curr[1],curr);
        }
        //将list再转换为数组并返回
        int[][] result=new int[len][];
        for (int i = 0; i < len; i++) {
            result[i]=list.get(i);
        }
        return result;
    }
}
