package com.ccsi.leetcode3;

import java.util.PriorityQueue;

/**
 * Created by gxliu on 2018/4/11.
 */
public class LC378SmallestElementInASortedMatrix {
    public static void main(String[] args) {
        int[][] matrix={{1,5,9},{10,11,13},{12,13,15}};
        System.out.println(kthSmallest1(matrix,8));
    }
    //priorityQueue
    public static int kthSmallest(int[][] matrix,int k){
        if(matrix==null||matrix.length==0||matrix[0]==null||matrix[0].length==0)return 0;
        int rowNum=matrix.length;
        int colNum=matrix[0].length;

        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->(b-a));
        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                pq.offer(matrix[row][col]);
                if(pq.size()>k)pq.poll();
            }
        }
        return pq.peek();
    }
    //二分法
    public static int kthSmallest1(int[][] matrix,int k){
        if(matrix==null||matrix.length==0||matrix[0]==null||matrix[0].length==0)return 0;
        int rowNum=matrix.length;
        int colNum=matrix[0].length;

        int left=matrix[0][0];
        int right=matrix[rowNum-1][colNum-1];
        while(left<right){
            int mid=left+(right-left)/2;
            int count=0;
            int j=colNum-1;
            for (int i = 0; i < rowNum; i++) {
                while(j>=0&&matrix[i][j]>mid)j--;
                count+=(j+1);
            }
            if(count<k)left=mid+1;
            else right=mid;
        }
        return left;
    }
}
