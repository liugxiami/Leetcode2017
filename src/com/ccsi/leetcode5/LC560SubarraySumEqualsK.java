package com.ccsi.leetcode5;

import java.util.*;

public class LC560SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] sums={1,1,1,1};
        System.out.println(subarraysSum1(sums,2));
    }
    //用queue，但如果有负数的话，就解决不了了。所以应该过不了。
    public static int subarraysSum(int[] sums,int k){
        if(sums==null||sums.length==0)return 0;
        Queue<Integer> queue=new LinkedList<>();
        int sum=0;
        int count=0;
        for (int i = 0; i < sums.length; i++) {
            sum+=sums[i];
            queue.offer(sums[i]);
            while (sum>k&&!queue.isEmpty()){
                sum-=queue.poll();
            }
            if(sum==k&&!queue.isEmpty()){
                count++;
                sum-=queue.poll();
            }
        }
        return count;
    }
    //参考了discussion，用presum和hashMap，sum[i，j]=sum[j]-sum[i-1]
    public static int subarraysSum1(int[] sums,int k){
        if(sums==null||sums.length==0)return 0;
        int sum=0;
        int count=0;
        Map<Integer,Integer> preSum=new HashMap<>();//key: preSum, value: frequency
        preSum.put(0,1);
        for (int i = 0; i < sums.length; i++) {
            sum+=sums[i];
            if(preSum.containsKey(sum-k))count+=preSum.get(sum-k);
            // it means there is some sum value v between 0 and x, which makes sum of array [x + 1 to i] == k
            // the frequency is the number of v
            preSum.put(sum,preSum.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
