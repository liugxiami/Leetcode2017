package com.ccsi.leetcode2;

import java.util.*;

/**
 * Created by gxliu on 2017/12/14.
 */
public class LC220ContainsDuplicateIII {
    public static void main(String[] args) {
        int[] nums={1,4,9,13,31,20,14,6};
        System.out.println(containsNearByAlmostDuplicate1(nums,3,1));
    }
    //method1,思路同上duplicateII，这里我们用两priorityQueue，一个为最大heap，一个为最小heap，看前面k个元素的最大最小元素，
    //通过与当前元素的比较是否绝对值<=t，如果是小于的那么返回true。注意及时更新pq和set。
    public static boolean containsNearByAlmostDuplicate(int[] nums,int k,int t){
        if(nums==null||nums.length<2||k<1||t<0)return false;
        PriorityQueue<Integer> minPQ=new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ=new PriorityQueue<>(nums.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        Set<Integer> set=new HashSet<>();

        minPQ.offer(nums[0]);
        maxPQ.offer(nums[0]);
        set.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if(Math.abs(nums[i]-minPQ.peek())<=t||
                    Math.abs(nums[i]-maxPQ.peek())<=t)return true;

            if(i-k>=0){
                minPQ.remove(nums[i-k]);
                maxPQ.remove(nums[i-k]);
                set.remove(nums[i-k]);
            }

            minPQ.offer(nums[i]);
            maxPQ.offer(nums[i]);
            set.add(nums[i]);
        }
        return false;
    }
    //桶排序的方法
    public static boolean containsNearByAlmostDuplicate1(int[] nums,int k,int t){
        if(nums==null||nums.length<2||k<1||t<0)return false;
        Map<Long,Integer> map=new HashMap<>();
        long div=(long)t+1;
        for (int i = 0; i < nums.length; i++) {
            long curr=nums[i]/div;//排除t作为0的情况。
            if(nums[i]<0)curr--; //在为负数时，比如-2/3==0与2/3==0就成同一个index 0了，这样不行，将-2/3变为-1。
            if(map.containsKey(curr)||map.containsKey(curr-1)&&Math.abs(map.get(curr-1)-nums[i])<=t||
                    map.containsKey(curr+1)&&Math.abs(map.get(curr+1)-nums[i])<=t)return true;

            if(i-k>=0){
                long first=nums[i-k]/div;
                if(nums[i-k]<0)first--;
                map.remove(first);
            }

            map.put(curr,nums[i]);
        }
        return false;
    }
}
