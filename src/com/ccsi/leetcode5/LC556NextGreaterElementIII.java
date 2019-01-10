package com.ccsi.leetcode5;

import java.util.*;

public class LC556NextGreaterElementIII {
    public static void main(String[] args) {
        System.out.println(nextGreaterElement1(21));
    }
    //method1 priorityQueue
    public static int nextGreaterElement(int n){
        if(n<10)return -1;
        String str=String.valueOf(n);
        char[] chars=str.toCharArray(); //先将数转成charArray，方便操作
        //从后往前看，找到第一对，后面的数比前面大的那一对。将这些都存进一个排好序的queue里面，将这pq里面第一个比数组中最前面那个大的放到最前面，
        //其他的从小到大放回到数组中去。
        PriorityQueue<Character> pq=new PriorityQueue<>(); //
        boolean hasNext=false;
        for (int i = chars.length-1; i >0 ; i--) {
            pq.offer(chars[i]);
            if(chars[i]>chars[i-1]){
                pq.offer(chars[i-1]);
                int index=i-1;
                int j=i;
                while(!pq.isEmpty()&&pq.peek()<=chars[index]){
                    chars[j++]=pq.poll();
                }
                if(!pq.isEmpty())chars[index]=pq.poll();
                while(!pq.isEmpty())chars[j++]=pq.poll();
                hasNext=true;
                break;
            }
        }
        if(!hasNext)return -1;
        long val=Integer.valueOf(new String(chars));
        return val>Integer.MAX_VALUE?-1:(int)val;
    }
    //method2 不用pq，调用Arrays.sort，sort是左闭右开（fromIndex，toIndex）
    public static int nextGreaterElement1(int n){
        if(n<10)return -1;
        char[] chars=String.valueOf(n).toCharArray();//转换成数组方便操作
        int index=chars.length-1;
        for (; index >0 ; index--) {
            if(chars[index-1]<chars[index])break; //从后往前看，找到第一对前面比后面小的数对，也就是说这两个数对调就可以得到一个较大的数。
        }
        if(index==0)return -1; //判断一下，如果一直找到头了也没找到，就返回-1.
        int smallesti=index; //注意，index-1是小的那个，index上的是大的
        for (int i = index+1; i < chars.length; i++) { //找到index之后比index-1位上刚好大的那个数
            if(chars[i]>chars[index-1]&&chars[i]<=chars[smallesti]){
                smallesti=i;
            }
        }
        char temp=chars[index-1]; //将找到刚好比index-1上的数大的数与index-1上的数对调
        chars[index-1]=chars[smallesti];
        chars[smallesti]=temp;

        Arrays.sort(chars,index,chars.length); //然后将index之后的数从小到大排序
        long val=Long.valueOf(String.valueOf(chars)); //得到的数转换成long类型，以防万一大于最大的整形数
        return val>Integer.MAX_VALUE?-1:(int)val; //return
    }
}
