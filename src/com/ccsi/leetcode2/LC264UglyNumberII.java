package com.ccsi.leetcode2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gxliu on 2017/12/31.
 */
public class LC264UglyNumberII {
    public static void main(String[] args) {
        int result=nthUglyNumber1(10);
        System.out.println(result);
    }
    //method1 DP, method2 3 queues
    public static int nthUglyNumber(int n){
        if(n<1)return 0;
        int[] cache=new int[n];
        int index2=0;
        int index3=0;
        int index5=0;
        cache[0]=1;
        for (int i = 1; i < n; i++) {
            cache[i]=Math.min(2*cache[index2],Math.min(3*cache[index3],5*cache[index5]));
            if(cache[i]==2*cache[index2])index2++;
            if(cache[i]==3*cache[index3])index3++;
            if(cache[i]==5*cache[index5])index5++;
        }
        return cache[n-1];
    }
    //method2 3 queues,有问题，result不能超过128，why？
    public static int nthUglyNumber1(int n){
        if(n<1)return 0;

        Queue<Long> queue2=new LinkedList<>();
        Queue<Long> queue3=new LinkedList<>();
        Queue<Long> queue5=new LinkedList<>();

        queue2.offer(2l);
        queue3.offer(3l);
        queue5.offer(5l);

        Long result=1l;
        while(n-->1){
           if(queue2.peek()<queue3.peek()&&queue2.peek()<queue5.peek()){
               result=queue2.poll();
               queue2.offer(result*2);
               queue3.offer(result*3);
               queue5.offer(result*5);
           }else if(queue3.peek()<queue2.peek()&&queue3.peek()<queue5.peek()){
               result=queue3.poll();
               queue3.offer(result*3);
               queue5.offer(result*5);
           }else{
               queue5.poll();
               queue5.offer(result*5);
           }
        }

        return result.intValue();
    }
}
